package no.nav.familie.kontrakter.felles.oppgave

import no.nav.familie.kontrakter.felles.jsonMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import tools.jackson.databind.exc.MismatchedInputException
import tools.jackson.module.kotlin.readValue

class OppdaterOppgaveNokkelordRequestTest {
    @Test
    fun `skal skrive og lese patch med bare nokkelord og gjeldende versjon`() {
        val request =
            OppdaterOppgaveNokkelordRequest(
                nokkelord = setOf("Barnetilsyn", "Revurdering"),
                meta = OppdaterOppgaveNokkelordRequest.Meta(versjon = 7),
            )
        val expectedJson =
            """
            {
                "nokkelord": ["Barnetilsyn", "Revurdering"],
                "meta": {"versjon": 7}
            }
            """.trimIndent()
        val json = jsonMapper.writeValueAsString(request)

        assertEquals(jsonMapper.readTree(expectedJson), jsonMapper.readTree(json))
        assertEquals(request, jsonMapper.readValue<OppdaterOppgaveNokkelordRequest>(expectedJson))
    }

    @Test
    fun `skal sende eksplisitt tom liste når nokkelord skal fjernes`() {
        val request =
            OppdaterOppgaveNokkelordRequest(
                nokkelord = emptySet(),
                meta = OppdaterOppgaveNokkelordRequest.Meta(versjon = 8),
            )
        val json = jsonMapper.writeValueAsString(request)

        assertEquals(jsonMapper.readTree("""{"nokkelord":[],"meta":{"versjon":8}}"""), jsonMapper.readTree(json))
        assertEquals(request, jsonMapper.readValue<OppdaterOppgaveNokkelordRequest>(json))
    }

    @Test
    fun `skal kreve at nokkelord er eksplisitt angitt`() {
        listOf(
            """{"meta":{"versjon":7}}""",
            """{"nokkelord":null,"meta":{"versjon":7}}""",
        ).forEach { json ->
            assertThrows(MismatchedInputException::class.java) {
                jsonMapper.readValue<OppdaterOppgaveNokkelordRequest>(json)
            }
        }
    }

    @Test
    fun `skal kreve gjeldende versjon uten standardverdi`() {
        listOf(
            """{"nokkelord":["Barnetilsyn"]}""",
            """{"nokkelord":["Barnetilsyn"],"meta":null}""",
            """{"nokkelord":["Barnetilsyn"],"meta":{}}""",
            """{"nokkelord":["Barnetilsyn"],"meta":{"versjon":null}}""",
        ).forEach { json ->
            assertThrows(MismatchedInputException::class.java) {
                jsonMapper.readValue<OppdaterOppgaveNokkelordRequest>(json)
            }
        }
    }
}
