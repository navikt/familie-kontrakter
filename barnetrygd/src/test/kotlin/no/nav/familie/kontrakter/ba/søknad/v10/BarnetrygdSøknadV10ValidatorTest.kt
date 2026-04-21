package no.nav.familie.kontrakter.ba.søknad.v10

import no.nav.familie.kontrakter.ba.søknad.v1.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ba.søknad.v1.SøknadAdresse
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.v5.RegistrertBostedType
import no.nav.familie.kontrakter.ba.søknad.v7.Søknaddokumentasjon
import no.nav.familie.kontrakter.ba.søknad.v7.Dokumentasjonsbehov
import no.nav.familie.kontrakter.ba.søknad.v7.Søknadsvedlegg
import no.nav.familie.kontrakter.ba.søknad.v8.AndreForelder
import no.nav.familie.kontrakter.ba.søknad.v8.AndreForelderUtvidet
import no.nav.familie.kontrakter.ba.søknad.v8.Arbeidsperiode
import no.nav.familie.kontrakter.ba.søknad.v8.EøsBarnetrygdsperiode
import no.nav.familie.kontrakter.ba.søknad.v8.Omsorgsperson
import no.nav.familie.kontrakter.ba.søknad.v8.Pensjonsperiode
import no.nav.familie.kontrakter.ba.søknad.v8.Utbetalingsperiode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt as FellesSøknadsfelt

class BarnetrygdSøknadV10ValidatorTest {
    private val gyldigLabel = mapOf("nb" to "Gyldig label", "nn" to "Gyldig label")
    private val gyldigVerdi = mapOf("nb" to "Gyldig verdi", "nn" to "Gyldig verdi")
    private val langStreng = "a".repeat(201)

    @Test
    fun `valider skal returnere tom liste når alle felter er gyldige`() {
        val søknad = lagGyldigSøknad()
        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertTrue(feil.isEmpty(), "Forventet ingen valideringsfeil for gyldig søknad")
    }

    @Test
    fun `valider skal returnere feil når søker ident label er for lang`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        ident =
                            FellesSøknadsfelt(
                                label = mapOf("nb" to langStreng),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                            FellesSøknadsfelt(
                                label = gyldigLabel,
                                verdi = mapOf("nb" to langStreng),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                    FellesSøknadsfelt(
                        label = mapOf("nn" to langStreng),
                        verdi = gyldigVerdi,
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].ident.label", feil[0].objectPath)
        assertEquals("nn", feil[0].locale)
    }

    @Test
    fun `valider skal returnere feil når barn spørsmål verdi er for lang`() {
        val barn =
            lagGyldigBarn().copy(
                spørsmål =
                    mapOf(
                        "testSpørsmål" to
                            FellesSøknadsfelt(
                                label = gyldigLabel,
                                verdi = mapOf("nb" to langStreng),
                            ),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].spørsmål.testSpørsmål.verdi", feil[0].objectPath)
        assertEquals("nb", feil[0].locale)
    }

    @Test
    fun `valider skal returnere feil når top-level spørsmål label er for lang`() {
        val søknad =
            lagGyldigSøknad().copy(
                spørsmål =
                    mapOf(
                        "topSpørsmål" to
                            Søknadsfelt(
                                label = mapOf("nb" to langStreng),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("spørsmål.topSpørsmål.label", feil[0].objectPath)
        assertEquals("nb", feil[0].locale)
    }

    @Test
    fun `valider skal returnere flere feil når flere felter er ugyldige`() {
        val barn =
            lagGyldigBarn().copy(
                ident =
                    FellesSøknadsfelt(
                        label = mapOf("nb" to langStreng, "nn" to langStreng),
                        verdi = gyldigVerdi,
                    ),
                navn =
                    FellesSøknadsfelt(
                        label = gyldigLabel,
                        verdi = mapOf("nb" to langStreng),
                    ),
            )

        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        navn =
                            FellesSøknadsfelt(
                                label = mapOf("nb" to langStreng),
                                verdi = gyldigVerdi,
                            ),
                    ),
                barn = listOf(barn),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(4, feil.size)
        assertTrue(feil.any { it.objectPath == "søker.navn.label" && it.locale == "nb" })
        assertTrue(feil.any { it.objectPath == "barn[0].ident.label" && it.locale == "nb" })
        assertTrue(feil.any { it.objectPath == "barn[0].ident.label" && it.locale == "nn" })
        assertTrue(feil.any { it.objectPath == "barn[0].navn.verdi" && it.locale == "nb" })
    }

    @Test
    fun `valider skal returnere feil når søker spørsmål har for lang label`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        spørsmål =
                            mapOf(
                                "testSpørsmål" to
                                    FellesSøknadsfelt(
                                        label = mapOf("nb" to langStreng),
                                        verdi = mapOf("nb" to "verdi"),
                                    ),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.spørsmål.testSpørsmål.label", feil[0].objectPath)
    }

    @Test
    fun `valider skal håndtere non-string verdier uten feil`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        spørsmål =
                            mapOf(
                                "booleanSpørsmål" to
                                    FellesSøknadsfelt(
                                        label = gyldigLabel,
                                        verdi = mapOf("nb" to true, "nn" to false),
                                    ),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertTrue(feil.isEmpty(), "Non-string verdier skal ikke forårsake valideringsfeil")
    }

    @Test
    fun `valider skal returnere feil når label er nøyaktig 201 tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        ident =
                            FellesSøknadsfelt(
                                label = mapOf("nb" to "a".repeat(201)),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                            FellesSøknadsfelt(
                                label = mapOf("nb" to "a".repeat(200)),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertTrue(feil.isEmpty(), "Label med nøyaktig 200 tegn skal være gyldig")
    }

    @Test
    fun `valider skal returnere feil når label inneholder mindre enn tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        ident =
                            FellesSøknadsfelt(
                                label = mapOf("nb" to "Test < verdi"),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                            FellesSøknadsfelt(
                                label = mapOf("nb" to "Test > verdi"),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                            FellesSøknadsfelt(
                                label = mapOf("nb" to "Test \"verdi\""),
                                verdi = mapOf("nb" to listOf("NOR")),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.statsborgerskap.label", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal returnere feil når v4 Søknadsfelt label inneholder ugyldige tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                spørsmål =
                    mapOf(
                        "testSpørsmål" to
                            Søknadsfelt(
                                label = mapOf("nb" to "Test<>verdi"),
                                verdi = gyldigVerdi,
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("spørsmål.testSpørsmål.label", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal returnere feil når verdi inneholder mindre enn tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        navn =
                            FellesSøknadsfelt(
                                label = gyldigLabel,
                                verdi = mapOf("nb" to "Test < verdi"),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.navn.verdi", feil[0].objectPath)
        assertEquals("nb", feil[0].locale)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
        assertTrue(feil[0].feilmelding.contains("Verdi"))
    }

    @Test
    fun `valider skal returnere feil når verdi inneholder større enn tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        ident =
                            FellesSøknadsfelt(
                                label = gyldigLabel,
                                verdi = mapOf("nb" to "Test > verdi"),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.ident.verdi", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
        assertTrue(feil[0].feilmelding.contains("Verdi"))
    }

    @Test
    fun `valider skal returnere feil når verdi inneholder anførselstegn`() {
        val barn =
            lagGyldigBarn().copy(
                navn =
                    FellesSøknadsfelt(
                        label = gyldigLabel,
                        verdi = mapOf("nb" to "Test \"verdi\""),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].navn.verdi", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
        assertTrue(feil[0].feilmelding.contains("Verdi"))
    }

    @Test
    fun `valider skal returnere feil når v4 Søknadsfelt verdi inneholder ugyldige tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                spørsmål =
                    mapOf(
                        "testSpørsmål" to
                            Søknadsfelt(
                                label = gyldigLabel,
                                verdi = mapOf("nb" to "Test<>verdi"),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("spørsmål.testSpørsmål.verdi", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    // --- Tester for teksterUtenomSpørsmål ---

    @Test
    fun `valider skal returnere feil når teksterUtenomSpørsmål har for lang streng`() {
        val søknad =
            lagGyldigSøknad().copy(
                teksterUtenomSpørsmål =
                    mapOf(
                        "tekst1" to mapOf("nb" to langStreng),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("teksterUtenomSpørsmål.tekst1", feil[0].objectPath)
        assertEquals("nb", feil[0].locale)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal returnere feil når teksterUtenomSpørsmål inneholder ugyldige tegn`() {
        val søknad =
            lagGyldigSøknad().copy(
                teksterUtenomSpørsmål =
                    mapOf(
                        "tekst1" to mapOf("nb" to "Test<script>alert</script>"),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("teksterUtenomSpørsmål.tekst1", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal returnere feil for flere locales i teksterUtenomSpørsmål`() {
        val søknad =
            lagGyldigSøknad().copy(
                teksterUtenomSpørsmål =
                    mapOf(
                        "tekst1" to mapOf("nb" to langStreng, "nn" to langStreng),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                            dokumentasjonSpråkTittel = mapOf("nb" to langStreng),
                        ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                            dokumentasjonSpråkTittel = mapOf("nb" to "Tittel med <html>"),
                        ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                            dokumentasjonSpråkTittel = mapOf("nb" to "Gyldig tittel"),
                        ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("dokumentasjon[0].opplastedeVedlegg[0].navn", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal returnere feil når vedlegg navn inneholder ugyldige tegn`() {
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
                                        navn = "fil<script>.pdf",
                                        tittel = Dokumentasjonsbehov.ANNEN_DOKUMENTASJON,
                                    ),
                                ),
                            dokumentasjonSpråkTittel = mapOf("nb" to "Gyldig tittel"),
                        ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("dokumentasjon[0].opplastedeVedlegg[0].navn", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
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
                            dokumentasjonSpråkTittel = mapOf("nb" to "Gyldig tittel"),
                        ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                        navn = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to langStreng)),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                            FellesSøknadsfelt(
                                label = mapOf("nb" to "Test<>verdi"),
                                verdi = mapOf("nb" to "NEI"),
                            ),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                                FellesSøknadsfelt(
                                    label = mapOf("nb" to langStreng),
                                    verdi = mapOf("nb" to Arbeidsperiode()),
                                ),
                            ),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].andreForelder.arbeidsperioderUtland[0].label", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Label overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal returnere feil når andreForelder utvidet har ugyldig felt`() {
        val barn =
            lagGyldigBarn().copy(
                andreForelder =
                    lagGyldigAndreForelder().copy(
                        utvidet =
                            AndreForelderUtvidet(
                                søkerHarBoddMedAndreForelder =
                                    FellesSøknadsfelt(
                                        label = gyldigLabel,
                                        verdi = mapOf("nb" to langStreng),
                                    ),
                            ),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].andreForelder.utvidet.søkerHarBoddMedAndreForelder.verdi", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal ikke returnere feil når andreForelder er null`() {
        val barn = lagGyldigBarn().copy(andreForelder = null)
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertTrue(feil.isEmpty())
    }

    // --- Tester for omsorgsperson ---

    @Test
    fun `valider skal returnere feil når omsorgsperson har ugyldig felt`() {
        val barn =
            lagGyldigBarn().copy(
                omsorgsperson =
                    lagGyldigOmsorgsperson().copy(
                        navn = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to langStreng)),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                            FellesSøknadsfelt(
                                label = mapOf("nb" to "Test<>verdi"),
                                verdi = mapOf("nb" to "FORELDER"),
                            ),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].omsorgsperson.slektsforhold.label", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal returnere feil når omsorgsperson liste-element har ugyldig felt`() {
        val barn =
            lagGyldigBarn().copy(
                omsorgsperson =
                    lagGyldigOmsorgsperson().copy(
                        pensjonsperioderNorge =
                            listOf(
                                FellesSøknadsfelt(
                                    label = gyldigLabel,
                                    verdi = mapOf("nb" to Pensjonsperiode()),
                                ),
                                FellesSøknadsfelt(
                                    label = mapOf("nb" to langStreng),
                                    verdi = mapOf("nb" to Pensjonsperiode()),
                                ),
                            ),
                    ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("barn[0].omsorgsperson.pensjonsperioderNorge[1].label", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Label overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal ikke returnere feil når omsorgsperson er null`() {
        val barn = lagGyldigBarn().copy(omsorgsperson = null)
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertTrue(feil.isEmpty())
    }

    // --- Tester for rekursiv validering av Any-verdier ---

    @Test
    fun `valider skal finne ugyldige strenger i Map-verdier via rekursiv traversering`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        spørsmål =
                            mapOf(
                                "nestedMap" to
                                    FellesSøknadsfelt(
                                        label = gyldigLabel,
                                        verdi = mapOf("nb" to mapOf("innerKey" to langStreng)),
                                    ),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.spørsmål.nestedMap.verdi.innerKey", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal finne ugyldige strenger i List-verdier via rekursiv traversering`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        spørsmål =
                            mapOf(
                                "nestedList" to
                                    FellesSøknadsfelt(
                                        label = gyldigLabel,
                                        verdi = mapOf("nb" to listOf("gyldig", langStreng)),
                                    ),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.spørsmål.nestedList.verdi[1]", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("Verdi overskrider maksimal lengde"))
    }

    @Test
    fun `valider skal finne ugyldige tegn i nestede strukturer via rekursiv traversering`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        spørsmål =
                            mapOf(
                                "deepNested" to
                                    FellesSøknadsfelt(
                                        label = gyldigLabel,
                                        verdi = mapOf("nb" to mapOf("level1" to listOf("ok", "test<xss>"))),
                                    ),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("søker.spørsmål.deepNested.verdi.level1[1]", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    @Test
    fun `valider skal ignorere non-string verdier i nestede strukturer`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        spørsmål =
                            mapOf(
                                "mixed" to
                                    FellesSøknadsfelt(
                                        label = gyldigLabel,
                                        verdi = mapOf("nb" to mapOf("bool" to true, "int" to 42, "str" to "gyldig")),
                                    ),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertTrue(feil.isEmpty(), "Non-string verdier i nestede strukturer skal ikke forårsake feil")
    }

    @Test
    fun `valider skal finne ugyldige strenger i v4 Søknadsfelt med nestede Map-verdier`() {
        val søknad =
            lagGyldigSøknad().copy(
                spørsmål =
                    mapOf(
                        "nestedSpørsmål" to
                            Søknadsfelt(
                                label = gyldigLabel,
                                verdi = mapOf("nb" to mapOf("key" to "ugyldig<verdi")),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertEquals(1, feil.size)
        assertEquals("spørsmål.nestedSpørsmål.verdi.key", feil[0].objectPath)
        assertTrue(feil[0].feilmelding.contains("ugyldige tegn"))
    }

    // --- Tester for refleksjonsbasert traversering av indre objekter ---

    @Test
    fun `valider skal finne ugyldig label inne i Utbetalingsperiode via refleksjon`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        andreUtbetalingsperioder =
                            listOf(
                                FellesSøknadsfelt(
                                    label = gyldigLabel,
                                    verdi =
                                        mapOf(
                                            "nb" to
                                                Utbetalingsperiode(
                                                    fårUtbetalingNå = FellesSøknadsfelt(label = mapOf("nb" to langStreng), verdi = mapOf("nb" to "JA")),
                                                    utbetalingLand = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Sverige")),
                                                    utbetalingFraDato = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "2020-01-01")),
                                                    utbetalingTilDato = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "2021-01-01")),
                                                ),
                                        ),
                                ),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                                FellesSøknadsfelt(
                                    label = gyldigLabel,
                                    verdi =
                                        mapOf(
                                            "nb" to
                                                Arbeidsperiode(
                                                    arbeidsgiver = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to langStreng)),
                                                ),
                                        ),
                                ),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

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
                                FellesSøknadsfelt(
                                    label = gyldigLabel,
                                    verdi =
                                        mapOf(
                                            "nb" to
                                                Pensjonsperiode(
                                                    pensjonsland = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Sverige<script>")),
                                                ),
                                        ),
                                ),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertTrue(feil.isNotEmpty(), "Forventet valideringsfeil for ugyldige tegn i Pensjonsperiode")
        assertTrue(feil.any { it.feilmelding.contains("ugyldige tegn") })
    }

    @Test
    fun `valider skal finne ugyldig felt inne i EøsBarnetrygdsperiode via refleksjon`() {
        val barn =
            lagGyldigBarn().copy(
                eøsBarnetrygdsperioder =
                    listOf(
                        FellesSøknadsfelt(
                            label = gyldigLabel,
                            verdi =
                                mapOf(
                                    "nb" to
                                        EøsBarnetrygdsperiode(
                                            barnetrygdsland = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Danmark")),
                                            fraDatoBarnetrygdperiode = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "2020-01-01")),
                                            månedligBeløp = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to langStreng)),
                                        ),
                        ),
                    ),
                ),
            )
        val søknad = lagGyldigSøknad().copy(barn = listOf(barn))

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertTrue(feil.isNotEmpty(), "Forventet valideringsfeil for ugyldig felt i EøsBarnetrygdsperiode")
        assertTrue(feil.any { it.feilmelding.contains("Verdi overskrider maksimal lengde") })
    }

    @Test
    fun `valider skal ikke gi feil for gyldige verdier inne i periodeobjekter`() {
        val søknad =
            lagGyldigSøknad().copy(
                søker =
                    lagGyldigSøker().copy(
                        arbeidsperioderUtland =
                            listOf(
                                FellesSøknadsfelt(
                                    label = gyldigLabel,
                                    verdi =
                                        mapOf(
                                            "nb" to
                                                Arbeidsperiode(
                                                    arbeidsperiodeAvsluttet = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "JA")),
                                                    arbeidsperiodeland = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Sverige")),
                                                    arbeidsgiver = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "IKEA")),
                                                    fraDatoArbeidsperiode = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "2020-01-01")),
                                                    tilDatoArbeidsperiode = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "2021-01-01")),
                                                ),
                                        ),
                                ),
                            ),
                    ),
            )

        val feil = BarnetrygdSøknadV10Validator.valider(søknad)

        assertTrue(feil.isEmpty(), "Forventet ingen feil for gyldige verdier i Arbeidsperiode")
    }

    private fun lagGyldigSøknad() =
        BarnetrygdSøknad(
            kontraktVersjon = 10,
            søker = lagGyldigSøker(),
            barn = listOf(lagGyldigBarn()),
            dokumentasjon = emptyList(),
            søknadstype = Søknadstype.ORDINÆR,
            antallEøsSteg = 0,
            finnesPersonMedAdressebeskyttelse = false,
            spørsmål = emptyMap(),
            teksterUtenomSpørsmål = emptyMap(),
            originalSpråk = "nb",
        )

    private fun lagGyldigSøker() =
        Søker(
            ident = FellesSøknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            harEøsSteg = false,
            navn = FellesSøknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            statsborgerskap = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to listOf("NOR"))),
            adresse =
                FellesSøknadsfelt(
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
            sivilstand = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to SIVILSTANDTYPE.GIFT)),
            spørsmål = emptyMap(),
        )

    private fun lagGyldigBarn() =
        Barn(
            ident = FellesSøknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            harEøsSteg = false,
            navn = FellesSøknadsfelt(label = gyldigLabel, verdi = gyldigVerdi),
            registrertBostedType =
                FellesSøknadsfelt(
                    label = gyldigLabel,
                    verdi = mapOf("nb" to RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
                ),
            spørsmål = emptyMap(),
        )

    private fun lagGyldigAndreForelder() =
        AndreForelder(
            kanIkkeGiOpplysninger = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            navn = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Ola Nordmann")),
            fnr = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "12345678910")),
            utvidet = AndreForelderUtvidet(),
        )

    private fun lagGyldigOmsorgsperson() =
        Omsorgsperson(
            navn = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Kari Nordmann")),
            slektsforhold = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "FORELDER")),
            idNummer = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "12345678910")),
            adresse = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "Testveien 1")),
            arbeidUtland = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            arbeidNorge = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "JA")),
            pensjonUtland = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            pensjonNorge = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            andreUtbetalinger = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            pågåendeSøknadFraAnnetEøsLand = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
            barnetrygdFraEøs = FellesSøknadsfelt(label = gyldigLabel, verdi = mapOf("nb" to "NEI")),
        )
}
