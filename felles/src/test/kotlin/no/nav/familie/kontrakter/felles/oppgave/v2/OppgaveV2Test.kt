package no.nav.familie.kontrakter.felles.oppgave.v2

import no.nav.familie.kontrakter.felles.jsonMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import tools.jackson.databind.DeserializationFeature
import tools.jackson.module.kotlin.readValue
import java.time.LocalDate
import java.time.OffsetDateTime

class OppgaveV2Test {
    private val mapper =
        jsonMapper
            .rebuild()
            .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .build()

    @Test
    fun `skal lese eksisterende oppgavefelter og nokkelord fra v2-respons`() {
        val json =
            """
            {
                "id": 9000000000,
                "kategorisering": {
                    "tema": {"kode": "ENF", "term": "Enslig forsørger", "ukjent": true},
                    "oppgavetype": {"kode": "GOD_VED", "term": "Godkjenne vedtak"},
                    "behandlingstema": {"kode": "ab0071"},
                    "behandlingstype": {"kode": "ae0118"}
                },
                "fordeling": {
                    "enhet": {"nr": "4489", "navn": "Nav-enhet"},
                    "mappe": {"id": 789, "navn": "Godkjenning", "tema": "ENF"},
                    "medarbeider": {"navident": "Z123456", "ukjent": true},
                    "ukjent": true
                },
                "prioritet": "NORMAL",
                "beskrivelse": "Godkjenn vedtak",
                "nokkelord": ["Barnetilsyn", "Revurdering"],
                "aktivDato": "2026-10-29",
                "fristDato": "2026-11-02",
                "versjon": 3,
                "bruker": {"ident": "12345678901", "type": "PERSON"},
                "status": "FERDIGSTILT",
                "arkivreferanse": {"saksnr": "123", "journalpostId": "456"},
                "tilknyttetSystem": "EF_SAK",
                "opprettet": {
                    "tidspunkt": "2026-10-29T08:00:00Z",
                    "av": {"system": "familie-integrasjoner"}
                },
                "endret": {
                    "tidspunkt": "2026-10-29T09:00:00Z",
                    "av": {
                        "enhet": {"nr": "4490"},
                        "medarbeider": {"navident": "Z654321"}
                    }
                },
                "lukket": {
                    "tidspunkt": "2026-10-29T10:00:00Z",
                    "av": {"system": "familie-integrasjoner"}
                },
                "utvidelser": {"behandlingId": "987"},
                "ukjent": true
            }
            """.trimIndent()
        val oppgave = mapper.readValue<OppgaveV2>(json)

        assertEquals(9000000000L, oppgave.id)
        assertEquals(Kodeverk("ENF"), oppgave.kategorisering.tema)
        assertEquals(Kodeverk("GOD_VED"), oppgave.kategorisering.oppgavetype)
        assertEquals(Kodeverk("ab0071"), oppgave.kategorisering.behandlingstema)
        assertEquals(Kodeverk("ae0118"), oppgave.kategorisering.behandlingstype)
        assertEquals(Enhet("4489"), oppgave.fordeling.enhet)
        assertEquals(Mappe(789L), oppgave.fordeling.mappe)
        assertEquals(Medarbeider("Z123456"), oppgave.fordeling.medarbeider)
        assertEquals(Prioritet.NORMAL, oppgave.prioritet)
        assertEquals("Godkjenn vedtak", oppgave.beskrivelse)
        assertEquals(listOf("Barnetilsyn", "Revurdering"), oppgave.nokkelord)
        assertEquals(LocalDate.of(2026, 10, 29), oppgave.aktivDato)
        assertEquals(LocalDate.of(2026, 11, 2), oppgave.fristDato)
        assertEquals(3, oppgave.versjon)
        assertEquals(Bruker("12345678901", Brukertype.PERSON), oppgave.bruker)
        assertEquals(OppgaveV2.Status.FERDIGSTILT, oppgave.status)
        assertEquals(Arkivreferanse("123", "456"), oppgave.arkivreferanse)
        assertEquals("EF_SAK", oppgave.tilknyttetSystem)
        assertEquals(OffsetDateTime.parse("2026-10-29T08:00:00Z"), oppgave.opprettet.tidspunkt)
        assertEquals("familie-integrasjoner", oppgave.opprettet.av?.system)
        assertEquals(OffsetDateTime.parse("2026-10-29T09:00:00Z"), oppgave.endret?.tidspunkt)
        assertEquals(Enhet("4490"), oppgave.endret?.av?.enhet)
        assertEquals(Medarbeider("Z654321"), oppgave.endret?.av?.medarbeider)
        assertEquals(OffsetDateTime.parse("2026-10-29T10:00:00Z"), oppgave.lukket?.tidspunkt)
        assertEquals(mapOf("behandlingId" to "987"), oppgave.utvidelser)

        val serialized = mapper.writeValueAsString(oppgave)
        assertEquals(oppgave, mapper.readValue<OppgaveV2>(serialized))
        val tree = mapper.readTree(serialized)
        assertFalse(tree["kategorisering"]["tema"].has("term"))
        assertFalse(tree["fordeling"]["mappe"].has("navn"))
        assertFalse(tree["fordeling"]["mappe"].has("tema"))
    }

    @Test
    fun `skal lese respons uten valgfrie felter`() {
        val json =
            """
            {
                "id": 123,
                "kategorisering": {
                    "tema": {"kode": "ENF"},
                    "oppgavetype": {"kode": "GOD_VED"}
                },
                "fordeling": {"enhet": {"nr": "4489"}},
                "prioritet": "NORMAL",
                "nokkelord": [],
                "versjon": 1,
                "status": "AAPEN",
                "opprettet": {"tidspunkt": "2026-10-29T08:00:00Z"}
            }
            """.trimIndent()
        val oppgave = mapper.readValue<OppgaveV2>(json)

        assertEquals(emptyList<String>(), oppgave.nokkelord)
        assertEquals(OppgaveV2.Status.AAPEN, oppgave.status)
        assertNull(oppgave.bruker)
        assertNull(oppgave.beskrivelse)
        assertNull(oppgave.arkivreferanse)
        assertNull(oppgave.endret)
        assertNull(oppgave.lukket)
        assertNull(oppgave.utvidelser)
    }
}
