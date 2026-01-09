package no.nav.familie.kontrakter.ba.søknad

import no.nav.familie.kontrakter.felles.jsonMapper
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import tools.jackson.module.kotlin.readValue

class VersjonertBarnetrygdSøknadSerializerTest {
    @Nested
    inner class VersjonertKontantstøtteSøknadTest {
        @Test
        fun `skal kunne deserialisere og serialisere VersjonertBarnetrygdSøknad hvis kontraktversjon er 10`() {
            // Arrange
            val barnetrygdSøknadV10 = lagBarnetrygdSøknadV10("12345678910", "12345678911")
            val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV10)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertBarnetrygdSøknad = jsonMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)
                val versjonertJson = jsonMapper.writeValueAsString(versjonertBarnetrygdSøknad)
                jsonMapper.readValue<VersjonertBarnetrygdSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere VersjonertBarnetrygdSøknad hvis kontraktversjon er 9`() {
            // Arrange
            val barnetrygdSøknadV9 = lagBarnetrygdSøknadV9("12345678910", "12345678911")
            val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV9)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertBarnetrygdSøknad = jsonMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)
                val versjonertJson = jsonMapper.writeValueAsString(versjonertBarnetrygdSøknad)
                jsonMapper.readValue<VersjonertBarnetrygdSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere VersjonertBarnetrygdSøknad hvis kontraktversjon er 8`() {
            // Arrange
            val barnetrygdSøknadV8 = lagBarnetrygdSøknadV8("12345678910", "12345678911")
            val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV8)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertBarnetrygdSøknad = jsonMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)
                val versjonertJson = jsonMapper.writeValueAsString(versjonertBarnetrygdSøknad)
                jsonMapper.readValue<VersjonertBarnetrygdSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere VersjonertBarnetrygdSøknad hvis kontraktversjon er 7`() {
            // Arrange
            val barnetrygdSøknadV7 = lagBarnetrygdSøknadV7("12345678910", "12345678911")
            val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV7)

            // Act & Assert
            assertDoesNotThrow {
                val versjonertBarnetrygdSøknad = jsonMapper.readValue<VersjonertBarnetrygdSøknad>(søknadJson)
                val versjonertJson = jsonMapper.writeValueAsString(versjonertBarnetrygdSøknad)
                jsonMapper.readValue<VersjonertBarnetrygdSøknad>(versjonertJson)
            }
        }
    }

    @Nested
    inner class StøttetVersjonertBarnetrygdSøknadTest {
        @Test
        fun `skal kunne deserialisere og serialisere StøttetVersjonertBarnetrygdSøknad hvis kontraktversjon er 9`() {
            // Arrange
            val barnetrygdSøknadV9 = lagBarnetrygdSøknadV9("12345678910", "12345678911")
            val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV9)

            // Act & Assert
            assertDoesNotThrow {
                val støttetVersjonertBarnetrygdSøknad =
                    jsonMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(søknadJson)
                val versjonertJson = jsonMapper.writeValueAsString(støttetVersjonertBarnetrygdSøknad)
                jsonMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(versjonertJson)
            }
        }

        @Test
        fun `skal kunne deserialisere og serialisere StøttetVersjonertBarnetrygdSøknad hvis kontraktversjon er 8`() {
            // Arrange
            val barnetrygdSøknadV8 = lagBarnetrygdSøknadV8("12345678910", "12345678911")
            val søknadJson = jsonMapper.writeValueAsString(barnetrygdSøknadV8)

            // Act & Assert
            assertDoesNotThrow {
                val støttetVersjonertBarnetrygdSøknad =
                    jsonMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(søknadJson)
                val versjonertJson = jsonMapper.writeValueAsString(støttetVersjonertBarnetrygdSøknad)
                jsonMapper.readValue<StøttetVersjonertBarnetrygdSøknad>(versjonertJson)
            }
        }
    }
}
