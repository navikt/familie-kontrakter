package no.nav.familie.kontrakter.ks.søknad.v6

import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt
import no.nav.familie.kontrakter.ks.søknad.v1.Dokumentasjonsbehov
import no.nav.familie.kontrakter.ks.søknad.v1.KontantstøttePeriode
import no.nav.familie.kontrakter.ks.søknad.v1.Pensjonsperiode
import no.nav.familie.kontrakter.ks.søknad.v1.RegistrertBostedType
import no.nav.familie.kontrakter.ks.søknad.v1.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ks.søknad.v1.SøknadAdresse
import no.nav.familie.kontrakter.ks.søknad.v1.Søknaddokumentasjon
import no.nav.familie.kontrakter.ks.søknad.v1.Søknadsvedlegg
import no.nav.familie.kontrakter.ks.søknad.v1.TekstPåSpråkMap
import no.nav.familie.kontrakter.ks.søknad.v1.Utbetalingsperiode
import no.nav.familie.kontrakter.ks.søknad.v2.Omsorgsperson
import no.nav.familie.kontrakter.ks.søknad.v4.AndreForelder
import no.nav.familie.kontrakter.ks.søknad.v4.Arbeidsperiode
import no.nav.familie.kontrakter.ks.søknad.v4.Søker
import no.nav.familie.kontrakter.ks.søknad.v4.Utenlandsperiode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KontantstøtteSøknadV6ValidatorTest {
    private val gyldigLabel = mapOf("nb" to "Gyldig label", "nn" to "Gyldig label")
    private val gyldigVerdi = mapOf("nb" to "Gyldig verdi", "nn" to "Gyldig verdi")
    private val langStreng = "a".repeat(201)

    @Test
    fun `valider skal returnere tom liste når alle felter er gyldige`() {
        val søknad = lagGyldigSøknad()
        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertTrue(feil.isEmpty(), "Forventet ingen valideringsfeil for gyldig søknad")
    }

    @Test
    fun `valider skal returnere feil når søker ident label er for lang`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        ident =
                            Søknadsfelt(
                                label = mapOf("nb" to langStreng),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.ident.label", feil[0].objectPath)
        assertEquals("nb", feil[0].locale)
        assertTrue(feil[0].feilmelding.contains("Label overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal returnere feil når søker navn verdi er for lang`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        navn =
                            Søknadsfelt(
                                label = gyldigLabel,
                                verdi = mapOf("nb" to langStreng),
                            ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.navn.verdi", feil[0].objectPath)
        assertEquals("nb", feil[0].locale)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal returnere feil når barn ident label er for lang`() {
        val barn =
            lagGyldigBarn().copy(
                ident =
                    Søknadsfelt(
                        label = mapOf("nn" to langStreng),
                        verdi = gyldigVerdi,
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].ident.label", feil[0].objectPath)
        assertEquals("nn", feil[0].locale)
    }

    @Test
    fun `valider skal returnere feil når toppnivå Søknadsfelt label er for lang`() {
        val søknad =
            lagGyldigSøknad().copy(
                erNoenAvBarnaFosterbarn =
                    Søknadsfelt(
                        label = mapOf("nb" to langStreng),
                        verdi = gyldigVerdi,
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("erNoenAvBarnaFosterbarn.label", feil[0].objectPath)
        assertEquals("nb", feil[0].locale)
    }

    @Test
    fun `valider skal returnere flere feil når flere felter er ugyldige`() {
        val barn =
            lagGyldigBarn().copy(
                ident =
                    Søknadsfelt(
                        label = mapOf("nb" to langStreng, "nn" to langStreng),
                        verdi = gyldigVerdi,
                    ),
                navn =
                    Søknadsfelt(
                        label = gyldigLabel,
                        verdi = mapOf("nb" to langStreng),
                    ),
            )

        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        navn =
                            Søknadsfelt(
                                label = mapOf("nb" to langStreng),
                                verdi = gyldigVerdi,
                            ),
                    ),
                barn = listOf(barn),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(4, feil.size)
        assertTrue(feil.any { it.objectPath == "søker.navn.label" && it.locale == "nb" })
        assertTrue(feil.any { it.objectPath == "barn[0].ident.label" && it.locale == "nb" })
        assertTrue(feil.any { it.objectPath == "barn[0].ident.label" && it.locale == "nn" })
        assertTrue(feil.any { it.objectPath == "barn[0].navn.verdi" && it.locale == "nb" })
    }

    @Test
    fun `valider skal returnere feil når label er nøyaktig 201 tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        ident =
                            Søknadsfelt(
                                label = mapOf("nb" to "a".repeat(201)),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertTrue(feil[0].feilmelding.contains("201"))
    }

    @Test
    fun `valider skal ikke returnere feil når label er nøyaktig 200 tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        ident =
                            Søknadsfelt(
                                label = mapOf("nb" to "a".repeat(200)),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertTrue(feil.isEmpty(), "Label med nøyaktig 200 tegn skal være gyldig")
    }

    @Test
    fun `valider skal returnere feil når label inneholder mindre enn tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        ident =
                            Søknadsfelt(
                                label = mapOf("nb" to "Test < verdi"),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.ident.label", feil[0].objectPath)
        assertEquals("nb", feil[0].locale)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal returnere feil når label inneholder større enn tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        navn =
                            Søknadsfelt(
                                label = mapOf("nb" to "Test > verdi"),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.navn.label", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal returnere feil når label inneholder anførselstegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        statsborgerskap =
                            Søknadsfelt(
                                label = mapOf("nb" to "Test \"verdi\""),
                                verdi = mapOf("nb" to listOf("NOR")),
                            ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.statsborgerskap.label", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal returnere feil når verdi inneholder ugyldige tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        navn =
                            Søknadsfelt(
                                label = gyldigLabel,
                                verdi = mapOf("nb" to "Test < verdi"),
                            ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.navn.verdi", feil[0].objectPath)
        assertEquals("nb", feil[0].locale)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
        assertTrue(feil[0].feilmelding.contains("Verdi"))
    }

    @Test
    fun `valider skal returnere feil når barn verdi inneholder anførselstegn`() {
        val barn =
            lagGyldigBarn().copy(
                navn =
                    Søknadsfelt(
                        label = gyldigLabel,
                        verdi = mapOf("nb" to "Test \"verdi\""),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].navn.verdi", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    // --- Tester for teksterTilPdf ---

    @Test
    fun `valider skal returnere feil når teksterTilPdf har for lang streng`() {
        val søknad =
            lagGyldigSøknad().copy(
                teksterTilPdf =
                    mapOf(
                        "tekst1" to TekstPåSpråkMap(mapOf("nb" to langStreng)),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("teksterTilPdf.tekst1", feil[0].objectPath)
        assertEquals("nb", feil[0].locale)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal returnere feil når teksterTilPdf inneholder ugyldige tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                teksterTilPdf =
                    mapOf(
                        "tekst1" to TekstPåSpråkMap(mapOf("nb" to "Test<script>alert</script>")),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("teksterTilPdf.tekst1", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal returnere feil for flere locales i teksterTilPdf`() {
        val søknad =
            lagGyldigSøknad().copy(
                teksterTilPdf =
                    mapOf(
                        "tekst1" to TekstPåSpråkMap(mapOf("nb" to langStreng, "nn" to langStreng)),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(2, feil.size)
        assertTrue(feil.any { it.locale == "nb" })
        assertTrue(feil.any { it.locale == "nn" })
    }

    // --- Tester for dokumentasjon ---

    @Test
    fun `valider skal returnere feil når dokumentasjon språktittel er for lang`() {
        val søknad =
            lagGyldigSøknad().copy(
                dokumentasjon =
                    listOf(
                        Søknaddokumentasjon(
                            dokumentasjonsbehov = Dokumentasjonsbehov.ANNEN_DOKUMENTASJON,
                            harSendtInn = false,
                            opplastedeVedlegg = emptyList(),
                            dokumentasjonSpråkTittel = TekstPåSpråkMap(mapOf("nb" to langStreng)),
                        ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("dokumentasjon[0].dokumentasjonSpråkTittel", feil[0].objectPath)
        assertEquals("nb", feil[0].locale)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal returnere feil når dokumentasjon språktittel inneholder ugyldige tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                dokumentasjon =
                    listOf(
                        Søknaddokumentasjon(
                            dokumentasjonsbehov = Dokumentasjonsbehov.ANNEN_DOKUMENTASJON,
                            harSendtInn = false,
                            opplastedeVedlegg = emptyList(),
                            dokumentasjonSpråkTittel = TekstPåSpråkMap(mapOf("nb" to "Tittel med <html>")),
                        ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("dokumentasjon[0].dokumentasjonSpråkTittel", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal returnere feil når vedlegg navn er for langt`() {
        val søknad =
            lagGyldigSøknad().copy(
                dokumentasjon =
                    listOf(
                        Søknaddokumentasjon(
                            dokumentasjonsbehov = Dokumentasjonsbehov.ANNEN_DOKUMENTASJON,
                            harSendtInn = false,
                            opplastedeVedlegg =
                                listOf(
                                    Søknadsvedlegg(
                                        dokumentId = "dok-123",
                                        navn = langStreng,
                                        tittel = Dokumentasjonsbehov.ANNEN_DOKUMENTASJON,
                                    ),
                                ),
                            dokumentasjonSpråkTittel = TekstPåSpråkMap(mapOf("nb" to "Gyldig tittel")),
                        ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("dokumentasjon[0].opplastedeVedlegg[0].navn", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal returnere feil når vedlegg dokumentId er for lang`() {
        val søknad =
            lagGyldigSøknad().copy(
                dokumentasjon =
                    listOf(
                        Søknaddokumentasjon(
                            dokumentasjonsbehov = Dokumentasjonsbehov.ANNEN_DOKUMENTASJON,
                            harSendtInn = false,
                            opplastedeVedlegg =
                                listOf(
                                    Søknadsvedlegg(
                                        dokumentId = langStreng,
                                        navn = "gyldig-fil.pdf",
                                        tittel = Dokumentasjonsbehov.ANNEN_DOKUMENTASJON,
                                    ),
                                ),
                            dokumentasjonSpråkTittel = TekstPåSpråkMap(mapOf("nb" to "Gyldig tittel")),
                        ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("dokumentasjon[0].opplastedeVedlegg[0].dokumentId", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    // --- Tester for andreForelder ---

    @Test
    fun `valider skal returnere feil når andreForelder har ugyldig felt`() {
        val barn =
            lagGyldigBarn().copy(
                andreForelder =
                    lagGyldigAndreForelder().copy(
                        navn = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to langStreng)),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].andreForelder.navn.verdi", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal returnere feil når andreForelder label inneholder ugyldige tegn`() {
        val barn =
            lagGyldigBarn().copy(
                andreForelder =
                    lagGyldigAndreForelder().copy(
                        kanIkkeGiOpplysninger =
                            Søknadsfelt(
                                label = mapOf("nb" to "Test<>verdi"),
                                verdi = mapOf("nb" to "NEI"),
                            ),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].andreForelder.kanIkkeGiOpplysninger.label", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal returnere feil når andreForelder liste-element har ugyldig felt`() {
        val barn =
            lagGyldigBarn().copy(
                andreForelder =
                    lagGyldigAndreForelder().copy(
                        arbeidsperioderUtland =
                            listOf(
                                Søknadsfelt(
                                    label = mapOf("nb" to langStreng),
                                    verdi =
                                        mapOf(
                                            "nb" to
                                                lagGyldigArbeidsperiode(),
                                        ),
                                ),
                            ),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].andreForelder.arbeidsperioderUtland[0].label", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Label overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal ikke returnere feil når andreForelder er null`() {
        val barn = lagGyldigBarn().copy(andreForelder = null)
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertTrue(feil.isEmpty())
    }

    // --- Tester for omsorgsperson ---

    @Test
    fun `valider skal returnere feil når omsorgsperson har ugyldig felt`() {
        val barn =
            lagGyldigBarn().copy(
                omsorgsperson =
                    lagGyldigOmsorgsperson().copy(
                        navn = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to langStreng)),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].omsorgsperson.navn.verdi", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal returnere feil når omsorgsperson label inneholder ugyldige tegn`() {
        val barn =
            lagGyldigBarn().copy(
                omsorgsperson =
                    lagGyldigOmsorgsperson().copy(
                        slektsforhold =
                            Søknadsfelt(
                                label = mapOf("nb" to "Test<>verdi"),
                                verdi = mapOf("nb" to "FORELDER"),
                            ),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].omsorgsperson.slektsforhold.label", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal ikke returnere feil når omsorgsperson er null`() {
        val barn = lagGyldigBarn().copy(omsorgsperson = null)
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertTrue(feil.isEmpty())
    }

    // --- Tester for rekursiv validering ---

    @Test
    fun `valider skal finne ugyldig label inne i Utbetalingsperiode via refleksjon`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        andreUtbetalingsperioder =
                            listOf(
                                Søknadsfelt(
                                    label = gyldigLabel,
                                    verdi =
                                        mapOf(
                                            "nb" to
                                                Utbetalingsperiode(
                                                    fårUtbetalingNå =
                                                        Søknadsfelt(
                                                            label = mapOf("nb" to langStreng),
                                                            verdi = mapOf("nb" to "JA"),
                                                        ),
                                                    utbetalingLand = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Sverige")),
                                                    utbetalingFraDato =
                                                        Søknadsfelt(
                                                            label = gyldigLabel,
                                                            verdi = mapOf("nb" to "2020-01-01"),
                                                        ),
                                                    utbetalingTilDato =
                                                        Søknadsfelt(
                                                            label = gyldigLabel,
                                                            verdi = mapOf("nb" to "2021-01-01"),
                                                        ),
                                                ),
                                        ),
                                ),
                            ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertTrue(feil.isNotEmpty(), "Forventet valideringsfeil for ugyldig label i Utbetalingsperiode")
        assertTrue(feil.any { it.feilmelding.contains("Label overskrider maksimal lengde") })
    }

    @Test
    fun `valider skal finne ugyldig verdi inne i Arbeidsperiode via refleksjon`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        arbeidsperioderUtland =
                            listOf(
                                Søknadsfelt(
                                    label = gyldigLabel,
                                    verdi =
                                        mapOf(
                                            "nb" to
                                                lagGyldigArbeidsperiode().copy(
                                                    arbeidsgiver =
                                                        Søknadsfelt(
                                                            label = gyldigLabel,
                                                            verdi = mapOf("nb" to langStreng),
                                                        ),
                                                ),
                                        ),
                                ),
                            ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertTrue(feil.isNotEmpty(), "Forventet valideringsfeil for ugyldig verdi i Arbeidsperiode")
        assertTrue(feil.any { it.feilmelding.contains("Verdi overskrider maksimal lengde") })
    }

    @Test
    fun `valider skal finne ugyldige tegn inne i Pensjonsperiode via refleksjon`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        pensjonsperioderUtland =
                            listOf(
                                Søknadsfelt(
                                    label = gyldigLabel,
                                    verdi =
                                        mapOf(
                                            "nb" to
                                                lagGyldigPensjonsperiode().copy(
                                                    pensjonsland =
                                                        Søknadsfelt(
                                                            label = gyldigLabel,
                                                            verdi = mapOf("nb" to "Sverige<script>"),
                                                        ),
                                                ),
                                        ),
                                ),
                            ),
                    ),
            )

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertTrue(feil.isNotEmpty(), "Forventet valideringsfeil for ugyldige tegn i Pensjonsperiode")
        assertTrue(feil.any { it.feilmelding.contains("ugyldige tegn") })
    }

    @Test
    fun `valider skal finne ugyldig felt inne i KontantstøttePeriode via refleksjon`() {
        val barn =
            lagGyldigBarn().copy(
                eøsKontantstøttePerioder =
                    listOf(
                        Søknadsfelt(
                            label = gyldigLabel,
                            verdi =
                                mapOf(
                                    "nb" to
                                        lagGyldigKontantstøttePeriode().copy(
                                            månedligBeløp = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to langStreng)),
                                        ),
                                ),
                        ),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertTrue(feil.isNotEmpty(), "Forventet valideringsfeil for ugyldig felt i KontantstøttePeriode")
        assertTrue(feil.any { it.feilmelding.contains("Verdi overskrider maksimal lengde") })
    }

    // --- Tester for barn teksterTilPdf ---

    @Test
    fun `valider skal returnere feil når barn teksterTilPdf har for lang streng`() {
        val barn =
            lagGyldigBarn().copy(
                teksterTilPdf =
                    mapOf(
                        "barnTekst" to TekstPåSpråkMap(mapOf("nb" to langStreng)),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = KontantstøtteSøknadV6Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].teksterTilPdf.barnTekst", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    private fun lagGyldigSøknad() =
        KontantstøtteSøknad(
            kontraktVersjon = 6,
            søker = lagGyldigSøker(),
            barn = listOf(lagGyldigBarn()),
            antallEøsSteg = 0,
            dokumentasjon = emptyList(),
            teksterTilPdf = emptyMap(),
            originalSpråk = "nb",
            finnesPersonMedAdressebeskyttelse = false,
            erNoenAvBarnaFosterbarn = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            søktAsylForBarn = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            oppholderBarnSegIInstitusjon = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            barnOppholdtSegTolvMndSammenhengendeINorge = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            erBarnAdoptert = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            mottarKontantstøtteForBarnFraAnnetEøsland = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            harEllerTildeltBarnehageplass = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            erAvdødPartnerForelder = null,
        )

    private fun lagGyldigSøker() =
        Søker(
            harEøsSteg = false,
            ident = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            navn = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            statsborgerskap = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to listOf("NOR"))),
            adresse =
                Søknadsfelt(
                    label = gyldigLabel,
                    verdi =
                        mapOf(
                            "nb" to
                                SøknadAdresse(
                                    adressenavn = "Testveien 1",
                                    postnummer = "0001",
                                    husbokstav = null,
                                    bruksenhetsnummer = null,
                                    husnummer = "1",
                                    poststed = "Oslo",
                                ),
                        ),
                ),
            adressebeskyttelse = false,
            sivilstand = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to SIVILSTANDTYPE.GIFT)),
            borPåRegistrertAdresse = null,
            værtINorgeITolvMåneder = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            planleggerÅBoINorgeTolvMnd = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            yrkesaktivFemÅr = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            erAsylsøker = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            utenlandsoppholdUtenArbeid = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            utenlandsperioder = emptyList(),
            arbeidIUtlandet = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            arbeidsperioderUtland = emptyList(),
            mottarUtenlandspensjon = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            pensjonsperioderUtland = emptyList(),
            arbeidINorge = null,
            arbeidsperioderNorge = emptyList(),
            pensjonNorge = null,
            pensjonsperioderNorge = emptyList(),
            andreUtbetalingsperioder = emptyList(),
            idNummer = emptyList(),
            andreUtbetalinger = null,
            adresseISøkeperiode = null,
        )

    private fun lagGyldigBarn() =
        Barn(
            harEøsSteg = false,
            ident = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            navn = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            registrertBostedType =
                Søknadsfelt(
                    label = gyldigLabel,
                    verdi = mapOf("nb" to RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
                ),
            alder = null,
            teksterTilPdf = emptyMap(),
            erFosterbarn = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            oppholderSegIInstitusjon = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            erAdoptert = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            erAsylsøker = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            boddMindreEnn12MndINorge = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            kontantstøtteFraAnnetEøsland = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            harBarnehageplass = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            andreForelderErDød = null,
            utbetaltForeldrepengerEllerEngangsstønad = null,
            mottarEllerMottokEøsKontantstøtte = null,
            pågåendeSøknadFraAnnetEøsLand = null,
            pågåendeSøknadHvilketLand = null,
            planleggerÅBoINorge12Mnd = null,
            borFastMedSøker = Søknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            foreldreBorSammen = null,
            søkerDeltKontantstøtte = null,
            andreForelder = null,
            søkersSlektsforhold = null,
            søkersSlektsforholdSpesifisering = null,
            borMedAndreForelder = null,
            borMedOmsorgsperson = null,
            adresse = null,
            omsorgsperson = null,
        )

    private fun lagGyldigAndreForelder() =
        AndreForelder(
            kanIkkeGiOpplysninger = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            navn = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Ola Nordmann")),
            fnr = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "12345678910")),
            fødselsdato = null,
            yrkesaktivFemÅr = null,
            arbeidUtlandet = null,
            utenlandsoppholdUtenArbeid = null,
            pensjonUtland = null,
            adresse = null,
            arbeidNorge = null,
            pensjonNorge = null,
            andreUtbetalinger = null,
            pågåendeSøknadFraAnnetEøsLand = null,
            pågåendeSøknadHvilketLand = null,
            kontantstøtteFraEøs = null,
        )

    private fun lagGyldigOmsorgsperson() =
        Omsorgsperson(
            navn = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Kari Nordmann")),
            slektsforhold = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "FORELDER")),
            slektsforholdSpesifisering = null,
            idNummer = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "12345678910")),
            adresse = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Testveien 1")),
            arbeidUtland = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            arbeidNorge = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "JA")),
            pensjonUtland = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            pensjonNorge = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            andreUtbetalinger = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            pågåendeSøknadFraAnnetEøsLand = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            pågåendeSøknadHvilketLand = null,
            kontantstøtteFraEøs = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
        )

    private fun lagGyldigArbeidsperiode() =
        Arbeidsperiode(
            arbeidsperiodeAvsluttet = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "JA")),
            arbeidsperiodeland = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Sverige")),
            arbeidsgiver = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "IKEA")),
            fraDatoArbeidsperiode = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "2020-01-01")),
            tilDatoArbeidsperiode = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "2021-01-01")),
            adresse = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Testveien 1")),
        )

    private fun lagGyldigPensjonsperiode() =
        Pensjonsperiode(
            mottarPensjonNå = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "JA")),
            pensjonsland = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Sverige")),
            pensjonFra = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "2020-01-01")),
            pensjonTil = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "2021-01-01")),
        )

    private fun lagGyldigKontantstøttePeriode() =
        KontantstøttePeriode(
            mottarEøsKontantstøtteNå = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "JA")),
            kontantstøtteLand = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Danmark")),
            fraDatoKontantstøttePeriode = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "2020-01-01")),
            tilDatoKontantstøttePeriode = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "2021-01-01")),
            månedligBeløp = Søknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "1000")),
        )
}
