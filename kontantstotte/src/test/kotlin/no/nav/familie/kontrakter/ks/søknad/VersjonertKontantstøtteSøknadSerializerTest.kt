package no.nav.familie.kontrakter.ks.søknad

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.objectMapper
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class VersjonertKontantstøtteSøknadSerializerTest {
    @Nested
    inner class VersjonertKontantstøtteSøknadTest {
        @Test
        fun `skal kunne deserialisere og serialisere VersjonertKontantstøtteSøknad kontraktversjon er 6`() {
            // Arrange
            val kontantstøtteSøknadV6 = lagKontantstøtteSøknadV6("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV6)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(versjonertKontantstøtteSøknad)
                objectMapper.readValue<VersjonertKontantstøtteSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere VersjonertKontantstøtteSøknad kontraktversjon er 5`() {
            // Arrange
            val kontantstøtteSøknadV5 = lagKontantstøtteSøknadV5("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV5)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(versjonertKontantstøtteSøknad)
                objectMapper.readValue<VersjonertKontantstøtteSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere VersjonertKontantstøtteSøknad kontraktversjon er 4`() {
            // Arrange
            val kontantstøtteSøknadV4 = lagKontantstøtteSøknadV4("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV4)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(versjonertKontantstøtteSøknad)
                objectMapper.readValue<VersjonertKontantstøtteSøknad>(versjonertJson)
            }
        }

        // Arrange
        @Test
        fun `skal kunne deserialisere og serialisere VersjonertKontantstøtteSøknad kontraktversjon er 3`() {
            val kontantstøtteSøknadV3 = lagKontantstøtteSøknadV3("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV3)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(versjonertKontantstøtteSøknad)
                objectMapper.readValue<VersjonertKontantstøtteSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere VersjonertKontantstøtteSøknad kontraktversjon er 2`() {
            // Arrange
            val kontantstøtteSøknadV2 = lagKontantstøtteSøknadV2("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV2)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(versjonertKontantstøtteSøknad)
                objectMapper.readValue<VersjonertKontantstøtteSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere VersjonertKontantstøtteSøknad kontraktversjon er 1`() {
            // Arrange
            val kontantstøtteSøknadV1 = lagKontantstøtteSøknadV1("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV1)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(versjonertKontantstøtteSøknad)
                objectMapper.readValue<VersjonertKontantstøtteSøknad>(versjonertJson)
            }
        }
    }

    @Nested
    inner class StøttetVersjonertKontantstøtteSøknadTest {
        @Test
        fun `skal kunne deserialisere og serialisere StøttetVersjonertKontantstøtteSøknad hvis kontraktversjon er 6`() {
            // Arrange
            val kontantstøtteSøknadV6 = lagKontantstøtteSøknadV6("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV6)

            // Act & Assert
            assertDoesNotThrow {
                val støttetVersjonertKontantStøtte = objectMapper.readValue<StøttetVersjonertKontantstøtteSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(støttetVersjonertKontantStøtte)
                objectMapper.readValue<StøttetVersjonertKontantstøtteSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere StøttetVersjonertKontantstøtteSøknad hvis kontraktversjon er 5`() {
            // Arrange
            val kontantstøtteSøknadV5 = lagKontantstøtteSøknadV5("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV5)

            // Act & Assert
            assertDoesNotThrow {
                val støttetVersjonertKontantStøtte = objectMapper.readValue<StøttetVersjonertKontantstøtteSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(støttetVersjonertKontantStøtte)
                objectMapper.readValue<StøttetVersjonertKontantstøtteSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere StøttetVersjonertKontantstøtteSøknad hvis kontraktversjon er 4`() {
            // Arrange
            val kontantstøtteSøknadV4 = lagKontantstøtteSøknadV4("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV4)

            // Act & Assert
            assertDoesNotThrow {
                val støttetVersjonertKontantStøtte = objectMapper.readValue<StøttetVersjonertKontantstøtteSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(støttetVersjonertKontantStøtte)
                objectMapper.readValue<StøttetVersjonertKontantstøtteSøknad>(versjonertJson)
            }
        }
    }
}
