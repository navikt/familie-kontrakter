package no.nav.familie.kontrakter.ks.søknad

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.objectMapper
import no.nav.familie.kontrakter.felles.søknad.MissingVersionException
import no.nav.familie.kontrakter.felles.søknad.UnsupportedVersionException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class VersjonertKontantstøtteSøknadDeserializerTest {
    @Test
    fun `skal kunne deserialisere KontantstøtteSøknad V6 til VersjonertKontantstøtteSøknad`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV6 = lagKontantstøtteSøknadV6(søkerFnr, barnFnr)
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV6)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV6 }
        assertEquals(6, versjonertKontantstøtteSøknad.kontantstøtteSøknad.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere KontantstøtteSøknad V5 til VersjonertKontantstøtteSøknad`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV5 = lagKontantstøtteSøknadV5(søkerFnr, barnFnr)
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV5)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV5 }
        assertEquals(5, versjonertKontantstøtteSøknad.kontantstøtteSøknad.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere KontantstøtteSøknad V6 til StøttetVersjonertKontantstøtteSøknad`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV6 = lagKontantstøtteSøknadV6(søkerFnr, barnFnr)
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV6)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<StøttetVersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV6 }
        assertEquals(6, versjonertKontantstøtteSøknad.kontantstøtteSøknad.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere KontantstøtteSøknad V5 til StøttetVersjonertKontantstøtteSøknad`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV5 = lagKontantstøtteSøknadV5(søkerFnr, barnFnr)
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV5)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<StøttetVersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV5 }
        assertEquals(5, versjonertKontantstøtteSøknad.kontantstøtteSøknad.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere KontantstøtteSøknad V4`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV4 = lagKontantstøtteSøknadV4(søkerFnr, barnFnr)
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV4)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV4 }
        assertEquals(4, versjonertKontantstøtteSøknad.kontantstøtteSøknad.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere KontantstøtteSøknad V4 til StøttetVersjonertKontantstøtteSøknad`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV4 = lagKontantstøtteSøknadV4(søkerFnr, barnFnr)
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV4)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<StøttetVersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV4 }
        assertEquals(4, versjonertKontantstøtteSøknad.kontantstøtteSøknad.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere KontantstøtteSøknad V3 når kontraktVersjon er 3`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV3 = lagKontantstøtteSøknadV3(søkerFnr, barnFnr)

        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV3)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV3 }
        assertEquals(3, versjonertKontantstøtteSøknad.kontantstøtteSøknad.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere til VersjonertKontantstøtteSøknadV2 når kontraktVersjon er 2`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV2 = lagKontantstøtteSøknadV2(søkerFnr, barnFnr)
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV2)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV2 }
        assertEquals(2, versjonertKontantstøtteSøknad.kontantstøtteSøknad.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kunne deserialisere til VersjonertKontantstøtteSøknadV1 når kontraktVersjon er 1`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV1 = lagKontantstøtteSøknadV1(søkerFnr, barnFnr)
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV1)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV1 }
        assertEquals(1, versjonertKontantstøtteSøknad.kontantstøtteSøknad.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad().size)
        assertEquals(
            listOf("12345678910", "12345678911"),
            versjonertKontantstøtteSøknad.kontantstøtteSøknad.personerISøknad(),
        )
    }

    @Test
    fun `skal kaste feil UnsupportedVersionException dersom JSON-string ikke inneholder feltet 'kontraktVersjon'`() {
        // Arrange
        val jsonString = """{"felt1":123,"felt2":"hei"}"""

        // Act & Assert
        val missingVersionException =
            assertThrows<MissingVersionException> { objectMapper.readValue<VersjonertKontantstøtteSøknad>(jsonString) }
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
            assertThrows<UnsupportedVersionException> { objectMapper.readValue<VersjonertKontantstøtteSøknad>(jsonString) }
        assertEquals(
            "Mangler implementasjon for versjon: 100 av KontantstøtteSøknad.",
            unsupportedVersionException.message,
        )
    }
}
