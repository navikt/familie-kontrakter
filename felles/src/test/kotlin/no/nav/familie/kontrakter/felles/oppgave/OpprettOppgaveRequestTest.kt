package no.nav.familie.kontrakter.felles.oppgave

import no.nav.familie.kontrakter.felles.Tema
import no.nav.familie.kontrakter.felles.jsonMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import tools.jackson.module.kotlin.readValue
import java.time.LocalDate

class OpprettOppgaveRequestTest {
    @Test
    fun `skal lese eksisterende forespørsler uten nokkelord`() {
        val request =
            jsonMapper.readValue<OpprettOppgaveRequest>(
                """
                {
                    "ident": {"ident": "12345678901", "gruppe": "FOLKEREGISTERIDENT"},
                    "enhetsnummer": "4489",
                    "saksId": "123",
                    "tema": "ENF",
                    "oppgavetype": "GodkjenneVedtak",
                    "behandlingstema": null,
                    "fristFerdigstillelse": "2026-11-02",
                    "beskrivelse": "Godkjenn vedtak"
                }
                """.trimIndent(),
            )

        assertNull(request.nokkelord)
        assertEquals(OppgavePrioritet.NORM, request.prioritet)
    }

    @Test
    fun `skal bevare eksisterende posisjonelle konstruktørargumenter`() {
        val request =
            OpprettOppgaveRequest(
                OppgaveIdentV2("12345678901", IdentGruppe.FOLKEREGISTERIDENT),
                "4489",
                "123",
                "456",
                Tema.ENF,
                Oppgavetype.GodkjenneVedtak,
                null,
                "Z123456",
                LocalDate.of(2026, 11, 2),
                LocalDate.of(2026, 10, 29),
                "Godkjenn vedtak",
                OppgavePrioritet.HOY,
                "ae0118",
                "EF_SAK",
                789L,
            )

        assertEquals(OppgavePrioritet.HOY, request.prioritet)
        assertEquals("ae0118", request.behandlingstype)
        assertEquals("EF_SAK", request.behandlesAvApplikasjon)
        assertEquals(789L, request.mappeId)
        assertNull(request.nokkelord)
    }

    @Test
    fun `skal skrive og lese nokkelord med riktig feltnavn`() {
        val request =
            OpprettOppgaveRequest(
                ident = OppgaveIdentV2("12345678901", IdentGruppe.FOLKEREGISTERIDENT),
                enhetsnummer = "4489",
                saksId = "123",
                tema = Tema.ENF,
                oppgavetype = Oppgavetype.GodkjenneVedtak,
                behandlingstema = null,
                fristFerdigstillelse = LocalDate.of(2026, 11, 2),
                beskrivelse = "Godkjenn vedtak",
                nokkelord = setOf("Barnetilsyn"),
            )
        val json = jsonMapper.writeValueAsString(request)
        val tree = jsonMapper.readTree(json)

        assertEquals(jsonMapper.readTree("""["Barnetilsyn"]"""), tree["nokkelord"])
        assertFalse(tree.has("noekkelOrd"))
        assertEquals(request, jsonMapper.readValue<OpprettOppgaveRequest>(json))
    }
}
