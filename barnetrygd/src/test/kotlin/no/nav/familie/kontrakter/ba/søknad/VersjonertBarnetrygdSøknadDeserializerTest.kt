package no.nav.familie.kontrakter.ba.søknad

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.ba.søknad.v1.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ba.søknad.v1.SøknadAdresse
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.v5.RegistrertBostedType
import no.nav.familie.kontrakter.felles.objectMapper
import no.nav.familie.kontrakter.felles.søknad.MissingVersionException
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt
import no.nav.familie.kontrakter.felles.søknad.UnsupportedVersionException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import no.nav.familie.kontrakter.ba.søknad.v7.Barn as BarnV7
import no.nav.familie.kontrakter.ba.søknad.v7.Søker as SøkerV7
import no.nav.familie.kontrakter.ba.søknad.v7.Søknad as BarnetrygdSøknadV7
import no.nav.familie.kontrakter.ba.søknad.v8.Barn as BarnV8
import no.nav.familie.kontrakter.ba.søknad.v8.Søker as SøkerV8
import no.nav.familie.kontrakter.ba.søknad.v8.Søknad as BarnetrygdSøknadV8
import no.nav.familie.kontrakter.ba.søknad.v9.BarnetrygdSøknad as BarnetrygdSøknadV9

class VersjonertBarnetrygdSøknadDeserializerTest {
    @Test
    fun `skal kunne deserialisere BarnetrygdSøknad V9 når kontraktVersjon er 9`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val barnetrygdSøknadV9 =
            BarnetrygdSøknadV9(
                kontraktVersjon = 9,
                søker = lagSøkerV8(søkerFnr),
                barn = listOf(lagBarnV8(barnFnr)),
                antallEøsSteg = 0,
                dokumentasjon = emptyList(),
                originalSpråk = "NB",
                finnesPersonMedAdressebeskyttelse = false,
                søknadstype = Søknadstype.ORDINÆR,
                spørsmål = emptyMap(),
                teksterUtenomSpørsmål = emptyMap(),
            )
        val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV9)

        // Act
        val versjonertBarnetrygdSøknad = objectMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertBarnetrygdSøknad)
        assertTrue(versjonertBarnetrygdSøknad is VersjonertBarnetrygdSøknadV9)
        assertEquals(9, versjonertBarnetrygdSøknad.barnetrygdSøknad.kontraktVersjon)
        assertEquals(2, versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere BarnetrygdSøknadV9 til StøttetVersjonertBarnetrygdSøknadV9 når kontraktVersjon er 9`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val barnetrygdSøknadV9 =
            BarnetrygdSøknadV9(
                kontraktVersjon = 9,
                søker = lagSøkerV8(søkerFnr),
                barn = listOf(lagBarnV8(barnFnr)),
                antallEøsSteg = 0,
                dokumentasjon = emptyList(),
                originalSpråk = "NB",
                finnesPersonMedAdressebeskyttelse = false,
                søknadstype = Søknadstype.ORDINÆR,
                spørsmål = emptyMap(),
                teksterUtenomSpørsmål = emptyMap(),
            )
        val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV9)

        // Act
        val versjonertBarnetrygdSøknad = objectMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertBarnetrygdSøknad)
        assertTrue(versjonertBarnetrygdSøknad is VersjonertBarnetrygdSøknadV9)
        assertEquals(9, versjonertBarnetrygdSøknad.barnetrygdSøknad.kontraktVersjon)
        assertEquals(2, versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere BarnetrygdSøknad V8 når kontraktVersjon er 8`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val barnetrygdSøknadV9 =
            BarnetrygdSøknadV8(
                kontraktVersjon = 8,
                søker = lagSøkerV8(søkerFnr),
                barn = listOf(lagBarnV8(barnFnr)),
                antallEøsSteg = 0,
                dokumentasjon = emptyList(),
                originalSpråk = "NB",
                søknadstype = Søknadstype.ORDINÆR,
                spørsmål = emptyMap(),
                teksterUtenomSpørsmål = emptyMap(),
            )
        val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV9)

        // Act
        val versjonertBarnetrygdSøknad = objectMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertBarnetrygdSøknad)
        assertTrue(versjonertBarnetrygdSøknad is VersjonertBarnetrygdSøknadV8)
        assertEquals(8, versjonertBarnetrygdSøknad.barnetrygdSøknad.kontraktVersjon)
        assertEquals(2, versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere BarnetrygdSøknadV8 til StøttetVersjonertBarnetrygdSøknad når kontraktVersjon er 8`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val barnetrygdSøknadV9 =
            BarnetrygdSøknadV8(
                kontraktVersjon = 8,
                søker = lagSøkerV8(søkerFnr),
                barn = listOf(lagBarnV8(barnFnr)),
                antallEøsSteg = 0,
                dokumentasjon = emptyList(),
                originalSpråk = "NB",
                søknadstype = Søknadstype.ORDINÆR,
                spørsmål = emptyMap(),
                teksterUtenomSpørsmål = emptyMap(),
            )
        val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV9)

        // Act
        val versjonertBarnetrygdSøknad = objectMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertBarnetrygdSøknad)
        assertTrue(versjonertBarnetrygdSøknad is VersjonertBarnetrygdSøknadV8)
        assertEquals(8, versjonertBarnetrygdSøknad.barnetrygdSøknad.kontraktVersjon)
        assertEquals(2, versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere BarnetrygdSøknad V7 når kontraktVersjon er 7`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val barnetrygdSøknadV9 =
            BarnetrygdSøknadV7(
                kontraktVersjon = 7,
                søker = lagSøkerV7(søkerFnr),
                barn = listOf(lagBarnV7(barnFnr)),
                antallEøsSteg = 0,
                dokumentasjon = emptyList(),
                originalSpråk = "NB",
                søknadstype = Søknadstype.ORDINÆR,
                spørsmål = emptyMap(),
                teksterUtenomSpørsmål = emptyMap(),
            )
        val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV9)

        // Act
        val versjonertBarnetrygdSøknad = objectMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertBarnetrygdSøknad)
        assertTrue(versjonertBarnetrygdSøknad is VersjonertBarnetrygdSøknadV7)
        assertEquals(7, versjonertBarnetrygdSøknad.barnetrygdSøknad.kontraktVersjon)
        assertEquals(2, versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kaste feil UnsupportedVersionException dersom JSON-string ikke inneholder feltet 'kontraktVersjon'`() {
        // Arrange
        val jsonString = """{"felt1":123,"felt2":"hei"}"""

        // Act & Assert
        val missingVersionException =
            assertThrows<MissingVersionException> { objectMapper.readValue<VersjonertBarnetrygdSøknad>(jsonString) }
        assertEquals(
            "JSON-string mangler feltet 'kontraktVersjon' og kan ikke deserialiseres. $jsonString",
            missingVersionException.message,
        )
    }

    @Test
    fun `skal kaste feil UnsupportedVersionException dersom feltet 'kontraktVersjon' ikke er støttet`() {
        // Arrange
        val jsonString = """{"kontraktVersjon":100}"""

        // Act & Assert
        val unsupportedVersionException =
            assertThrows<UnsupportedVersionException> { objectMapper.readValue<VersjonertBarnetrygdSøknad>(jsonString) }
        assertEquals(
            "Mangler implementasjon for versjon: 100 av BarnetrygdSøknad.",
            unsupportedVersionException.message,
        )
    }

    private fun <T> lagStringSøknadsfelt(verdi: T): Søknadsfelt<T> =
        Søknadsfelt(
            label = mapOf("no" to ""),
            verdi = mapOf("no" to verdi),
        )

    private fun lagSøkerV8(fnr: String): SøkerV8 =
        SøkerV8(
            harEøsSteg = false,
            ident = lagStringSøknadsfelt(fnr),
            navn = lagStringSøknadsfelt("Navn"),
            statsborgerskap = lagStringSøknadsfelt(listOf("Norge")),
            adresse =
                lagStringSøknadsfelt(
                    SøknadAdresse(
                        adressenavn = "Gate",
                        postnummer = null,
                        husbokstav = null,
                        bruksenhetsnummer = null,
                        husnummer = null,
                        poststed = null,
                    ),
                ),
            adressebeskyttelse = false,
            sivilstand = lagStringSøknadsfelt(SIVILSTANDTYPE.UOPPGITT),
            utenlandsperioder = emptyList(),
            arbeidsperioderUtland = emptyList(),
            pensjonsperioderUtland = emptyList(),
            arbeidsperioderNorge = emptyList(),
            pensjonsperioderNorge = emptyList(),
            andreUtbetalingsperioder = emptyList(),
            idNummer = emptyList(),
            spørsmål = emptyMap(),
            nåværendeSamboer = null,
            tidligereSamboere = emptyList(),
        )

    private fun lagSøkerV7(fnr: String): SøkerV7 =
        SøkerV7(
            harEøsSteg = false,
            ident = lagStringSøknadsfelt(fnr),
            navn = lagStringSøknadsfelt("Navn"),
            statsborgerskap = lagStringSøknadsfelt(listOf("Norge")),
            adresse =
                lagStringSøknadsfelt(
                    SøknadAdresse(
                        adressenavn = "Gate",
                        postnummer = null,
                        husbokstav = null,
                        bruksenhetsnummer = null,
                        husnummer = null,
                        poststed = null,
                    ),
                ),
            sivilstand = lagStringSøknadsfelt(SIVILSTANDTYPE.UOPPGITT),
            utenlandsperioder = emptyList(),
            arbeidsperioderUtland = emptyList(),
            pensjonsperioderUtland = emptyList(),
            arbeidsperioderNorge = emptyList(),
            pensjonsperioderNorge = emptyList(),
            andreUtbetalingsperioder = emptyList(),
            idNummer = emptyList(),
            spørsmål = emptyMap(),
            nåværendeSamboer = null,
            tidligereSamboere = emptyList(),
        )

    private fun lagBarnV8(fnr: String): BarnV8 =
        BarnV8(
            harEøsSteg = false,
            ident = lagStringSøknadsfelt(fnr),
            navn = lagStringSøknadsfelt(""),
            registrertBostedType = lagStringSøknadsfelt(RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
            alder = null,
            andreForelder = null,
            utenlandsperioder = emptyList(),
            omsorgsperson = null,
            idNummer = emptyList(),
            spørsmål = emptyMap(),
            eøsBarnetrygdsperioder = emptyList(),
        )

    private fun lagBarnV7(fnr: String): BarnV7 =
        BarnV7(
            harEøsSteg = false,
            ident = lagStringSøknadsfelt(fnr),
            navn = lagStringSøknadsfelt(""),
            registrertBostedType = lagStringSøknadsfelt(RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
            alder = lagStringSøknadsfelt("1"),
            andreForelder = null,
            utenlandsperioder = emptyList(),
            omsorgsperson = null,
            idNummer = emptyList(),
            spørsmål = emptyMap(),
            eøsBarnetrygdsperioder = emptyList(),
        )
}
