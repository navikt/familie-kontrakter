package no.nav.familie.kontrakter.ba.søknad

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.objectMapper
import no.nav.familie.kontrakter.felles.søknad.MissingVersionException
import no.nav.familie.kontrakter.felles.søknad.UnsupportedVersionException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class VersjonertBarnetrygdSøknadDeserializerTest {
    @Test
    fun `skal kunne deserialisere BarnetrygdSøknad V9 når kontraktVersjon er 9`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val barnetrygdSøknadV9 = lagBarnetrygdSøknadV9(søkerFnr, barnFnr)
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
        val barnetrygdSøknadV9 = lagBarnetrygdSøknadV9(søkerFnr, barnFnr)
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
        val barnetrygdSøknadV8 = lagBarnetrygdSøknadV8(søkerFnr, barnFnr)
        val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV8)

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
        val barnetrygdSøknadV8 = lagBarnetrygdSøknadV8(søkerFnr, barnFnr)
        val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV8)

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
        val barnetrygdSøknadV7 = lagBarnetrygdSøknadV7(søkerFnr, barnFnr)
        val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV7)

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
}
