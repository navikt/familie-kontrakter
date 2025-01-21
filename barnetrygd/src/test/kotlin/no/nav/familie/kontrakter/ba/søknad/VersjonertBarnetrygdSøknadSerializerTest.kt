package no.nav.familie.kontrakter.ba.søknad

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.objectMapper
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class VersjonertBarnetrygdSøknadSerializerTest {
    @Nested
    inner class VersjonertKontantstøtteSøknadTest {
        @Test
        fun `skal kunne deserialisere og serialisere VersjonertBarnetrygdSøknad hvis kontraktversjon er 9`() {
            // Arrange
            val barnetrygdSøknadV9 = lagBarnetrygdSøknadV9("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV9)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertBarnetrygdSøknad = objectMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(versjonertBarnetrygdSøknad)
                objectMapper.readValue<VersjonertBarnetrygdSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere VersjonertBarnetrygdSøknad hvis kontraktversjon er 8`() {
            // Arrange
            val barnetrygdSøknadV8 = lagBarnetrygdSøknadV8("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV8)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertBarnetrygdSøknad = objectMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(versjonertBarnetrygdSøknad)
                objectMapper.readValue<VersjonertBarnetrygdSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere VersjonertBarnetrygdSøknad hvis kontraktversjon er 7`() {
            // Arrange
            val barnetrygdSøknadV7 = lagBarnetrygdSøknadV7("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV7)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertBarnetrygdSøknad = objectMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(versjonertBarnetrygdSøknad)
                objectMapper.readValue<VersjonertBarnetrygdSøknad>(versjonertJson)
            }
        }
    }

    @Nested
    inner class StøttetVersjonertBarnetrygdSøknadTest {
        @Test
        fun `skal kunne deserialisere og serialisere StøttetVersjonertBarnetrygdSøknad hvis kontraktversjon er 9`() {
            // Arrange
            val barnetrygdSøknadV9 = lagBarnetrygdSøknadV9("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV9)

            // Act & Assert
            assertDoesNotThrow {
                val støttetVersjonertBarnetrygdSøknad =
                    objectMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(støttetVersjonertBarnetrygdSøknad)
                objectMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere StøttetVersjonertBarnetrygdSøknad hvis kontraktversjon er 8`() {
            // Arrange
            val barnetrygdSøknadV8 = lagBarnetrygdSøknadV8("12345678910", "12345678911")
            val søknadJson = objectMapper.writeValueAsString(barnetrygdSøknadV8)

            // Act & Assert
            assertDoesNotThrow {
                val støttetVersjonertBarnetrygdSøknad =
                    objectMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(søknadJson)
                val versjonertJson = objectMapper.writeValueAsString(støttetVersjonertBarnetrygdSøknad)
                objectMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(versjonertJson)
            }
        }
    }
}
