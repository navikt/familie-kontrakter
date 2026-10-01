package no.nav.familie.kontrakter.ba.søknad

import no.nav.familie.kontrakter.ba.søknad.v11.Dokumentasjonsbehov
import no.nav.familie.kontrakter.ba.søknad.v11.Søknaddokumentasjon
import no.nav.familie.kontrakter.felles.jsonMapper
import no.nav.familie.kontrakter.felles.søknad.BaFellesDokumentasjonsbehov
import no.nav.familie.kontrakter.felles.søknad.MissingVersionException
import no.nav.familie.kontrakter.felles.søknad.UnsupportedVersionException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import tools.jackson.module.kotlin.readValue

class VersjonertBarnetrygdSøknadDeserializerTest {
    @Test
    fun `skal kunne deserialisere BarnetrygdSøknad V11 med de nye dokumentasjonsbehovene`() {
        val søknad =
            lagBarnetrygdSøknadV11("12345678910", "12345678911").copy(
                dokumentasjon =
                    listOf(
                        Søknaddokumentasjon(
                            dokumentasjonsbehov = Dokumentasjonsbehov.BEKREFTELSE_FRA_BARNEVERN_FOSTERHJEM,
                            harSendtInn = false,
                            opplastedeVedlegg = emptyList(),
                            dokumentasjonSpråkTittel = emptyMap(),
                        ),
                        Søknaddokumentasjon(
                            dokumentasjonsbehov = Dokumentasjonsbehov.BEKREFTELSE_FRA_BARNEVERN_BEREDSKAPSHJEM,
                            harSendtInn = false,
                            opplastedeVedlegg = emptyList(),
                            dokumentasjonSpråkTittel = emptyMap(),
                        ),
                    ),
            )
        val søknadJson = jsonMapper.writeValueAsString(søknad)

        val versjonertBarnetrygdSøknad = jsonMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)

        assertTrue(versjonertBarnetrygdSøknad is VersjonertBarnetrygdSøknadV11)
        assertEquals(11, versjonertBarnetrygdSøknad.barnetrygdSøknad.kontraktVersjon)
        assertEquals(
            listOf(
                Dokumentasjonsbehov.BEKREFTELSE_FRA_BARNEVERN_FOSTERHJEM,
                Dokumentasjonsbehov.BEKREFTELSE_FRA_BARNEVERN_BEREDSKAPSHJEM,
            ),
            (versjonertBarnetrygdSøknad.barnetrygdSøknad as no.nav.familie.kontrakter.ba.søknad.v11.BarnetrygdSøknad)
                .dokumentasjon
                .map { it.dokumentasjonsbehov },
        )
        assertEquals(
            BaFellesDokumentasjonsbehov.BekreftelseFraBarnevernFosterhjem,
            Dokumentasjonsbehov.BEKREFTELSE_FRA_BARNEVERN_FOSTERHJEM.tilFellesDokumentasjonsbehov(),
        )
        assertEquals(
            BaFellesDokumentasjonsbehov.BekreftelseFraBarnevernBeredskapshjem,
            Dokumentasjonsbehov.BEKREFTELSE_FRA_BARNEVERN_BEREDSKAPSHJEM.tilFellesDokumentasjonsbehov(),
        )
    }

    @Test
    fun `skal kunne deserialisere BarnetrygdSøknad V10 når kontraktVersjon er 10`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val barnetrygdSøknadV10 = lagBarnetrygdSøknadV10(søkerFnr, barnFnr)
        val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV10)

        // Act
        val versjonertBarnetrygdSøknad = jsonMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertBarnetrygdSøknad)
        assertTrue(versjonertBarnetrygdSøknad is VersjonertBarnetrygdSøknadV10)
        assertEquals(10, versjonertBarnetrygdSøknad.barnetrygdSøknad.kontraktVersjon)
        assertEquals(2, versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere BarnetrygdSøknadV10 til StøttetVersjonertBarnetrygdSøknadV10 når kontraktVersjon er 10`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val barnetrygdSøknadV10 = lagBarnetrygdSøknadV10(søkerFnr, barnFnr)
        val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV10)

        // Act
        val versjonertBarnetrygdSøknad = jsonMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertBarnetrygdSøknad)
        assertTrue(versjonertBarnetrygdSøknad is VersjonertBarnetrygdSøknadV10)
        assertEquals(10, versjonertBarnetrygdSøknad.barnetrygdSøknad.kontraktVersjon)
        assertEquals(2, versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertBarnetrygdSøknad.barnetrygdSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere BarnetrygdSøknad V9 når kontraktVersjon er 9`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val barnetrygdSøknadV9 = lagBarnetrygdSøknadV9(søkerFnr, barnFnr)
        val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV9)

        // Act
        val versjonertBarnetrygdSøknad = jsonMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)

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
        val barnetrygdSøknadV9 = lagBarnetrygdSøknadV9(søkerFnr, barnFnr)
        val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV9)

        // Act
        val versjonertBarnetrygdSøknad = jsonMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(søknadJson)

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
        val barnetrygdSøknadV8 = lagBarnetrygdSøknadV8(søkerFnr, barnFnr)
        val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV8)

        // Act
        val versjonertBarnetrygdSøknad = jsonMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)

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
        val barnetrygdSøknadV8 = lagBarnetrygdSøknadV8(søkerFnr, barnFnr)
        val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV8)

        // Act
        val versjonertBarnetrygdSøknad = jsonMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(søknadJson)

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
        val barnetrygdSøknadV7 = lagBarnetrygdSøknadV7(søkerFnr, barnFnr)
        val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV7)

        // Act
        val versjonertBarnetrygdSøknad = jsonMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)

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
            assertThrows<MissingVersionException> { jsonMapper.readValue<VersjonertBarnetrygdSøknad>(jsonString) }
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
            assertThrows<UnsupportedVersionException> { jsonMapper.readValue<VersjonertBarnetrygdSøknad>(jsonString) }
        assertEquals(
            "Mangler implementasjon for versjon: 100 av BarnetrygdSøknad.",
            unsupportedVersionException.message,
        )
    }
}
