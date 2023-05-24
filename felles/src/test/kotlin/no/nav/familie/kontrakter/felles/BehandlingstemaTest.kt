package no.nav.familie.kontrakter.felles

import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class BehandlingstemaTest {
    @Test
    internal fun `skal kunne parsea fra enum name`() {
        assertEquals(Behandlingstema.Barnetilsyn, readJsonString(Behandlingstema.Barnetilsyn.name).first())
    }

    @Test
    internal fun `skal kunne parsea fra enum value`() {
        assertEquals(Behandlingstema.Barnetilsyn, readJsonString(Behandlingstema.Barnetilsyn.value).first())
    }

    @Test
    internal fun `serialisering av behandlingstema skal gi value`() {
        assertEquals(
            asJsonList(Behandlingstema.Barnetilsyn.value),
            objectMapper.writeValueAsString(listOf(Behandlingstema.Barnetilsyn)),
        )
    }

    private fun readJsonString(s: String) =
        objectMapper.readValue<List<Behandlingstema>>(asJsonList(s))

    private fun asJsonList(s: String) = "[\"$s\"]"
}
