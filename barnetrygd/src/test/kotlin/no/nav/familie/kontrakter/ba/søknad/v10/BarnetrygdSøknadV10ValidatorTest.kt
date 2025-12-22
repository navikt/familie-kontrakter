package no.nav.familie.kontrakter.ba.søknad.v10

import no.nav.familie.kontrakter.ba.søknad.v1.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ba.søknad.v1.SøknadAdresse
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.v5.RegistrertBostedType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt as FellesSøknadsfelt

class BarnetrygdSøknadV10ValidatorTest {
    private val gyldigEtikett = mapOf("nb" to "Gyldig etikett", "nn" to "Gyldig etikett")
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
                                label = gyldigEtikett,
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
                                label = gyldigEtikett,
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
                        label = gyldigEtikett,
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
                                        label = gyldigEtikett,
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

        assertTrue(feil.isEmpty(), "Etikett med nøyaktig 200 tegn skal være gyldig")
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
            ident = FellesSøknadsfelt(label = gyldigEtikett, verdi = gyldigVerdi),
            harEøsSteg = false,
            navn = FellesSøknadsfelt(label = gyldigEtikett, verdi = gyldigVerdi),
            statsborgerskap = FellesSøknadsfelt(label = gyldigEtikett, verdi = mapOf("nb" to listOf("NOR"))),
            adresse =
                FellesSøknadsfelt(
                    label = gyldigEtikett,
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
            sivilstand = FellesSøknadsfelt(label = gyldigEtikett, verdi = mapOf("nb" to SIVILSTANDTYPE.GIFT)),
            spørsmål = emptyMap(),
        )

    private fun lagGyldigBarn() =
        Barn(
            ident = FellesSøknadsfelt(label = gyldigEtikett, verdi = gyldigVerdi),
            harEøsSteg = false,
            navn = FellesSøknadsfelt(label = gyldigEtikett, verdi = gyldigVerdi),
            registrertBostedType =
                FellesSøknadsfelt(
                    label = gyldigEtikett,
                    verdi = mapOf("nb" to RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
                ),
            spørsmål = emptyMap(),
        )
}
