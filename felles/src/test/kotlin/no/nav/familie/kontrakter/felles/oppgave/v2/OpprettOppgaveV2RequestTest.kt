package no.nav.familie.kontrakter.felles.oppgave.v2

import no.nav.familie.kontrakter.felles.jsonMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import tools.jackson.module.kotlin.readValue
import java.time.LocalDate

class OpprettOppgaveV2RequestTest {
    private val kategorisering =
        Kategorisering(
            tema = Kodeverk("ENF"),
            oppgavetype = Kodeverk("GOD_VED"),
        )

    @Test
    fun `skal skrive og lese opprettelse med v2-struktur`() {
        val request =
            OpprettOppgaveV2Request(
                kategorisering =
                    kategorisering.copy(
                        behandlingstema = Kodeverk("ab0071"),
                        behandlingstype = Kodeverk("ae0118"),
                    ),
                fordeling =
                    OpprettOppgaveV2Request.Fordeling(
                        enhet = Enhet("4489"),
                        mappe = Mappe(789L),
                        medarbeider = Medarbeider("Z123456"),
                    ),
                beskrivelse = "Godkjenn vedtak",
                prioritet = Prioritet.NORMAL,
                fristDato = LocalDate.of(2026, 11, 2),
                aktivDato = LocalDate.of(2026, 10, 29),
                nokkelord = setOf("Barnetilsyn", "Revurdering"),
                bruker = Bruker("12345678901", Brukertype.PERSON),
                arkivreferanse = Arkivreferanse(saksnr = "123", journalpostId = "456"),
                tilknyttetSystem = "EF_SAK",
                meta =
                    OpprettOppgaveV2Request.Meta(
                        representerer = OpprettOppgaveV2Request.Representerer(Enhet("4490")),
                    ),
            )
        val expectedJson =
            """
            {
                "kategorisering": {
                    "tema": {"kode": "ENF"},
                    "oppgavetype": {"kode": "GOD_VED"},
                    "behandlingstema": {"kode": "ab0071"},
                    "behandlingstype": {"kode": "ae0118"}
                },
                "fordeling": {
                    "enhet": {"nr": "4489"},
                    "mappe": {"id": 789},
                    "medarbeider": {"navident": "Z123456"}
                },
                "beskrivelse": "Godkjenn vedtak",
                "prioritet": "NORMAL",
                "fristDato": "2026-11-02",
                "aktivDato": "2026-10-29",
                "nokkelord": ["Barnetilsyn", "Revurdering"],
                "bruker": {"ident": "12345678901", "type": "PERSON"},
                "arkivreferanse": {"saksnr": "123", "journalpostId": "456"},
                "tilknyttetSystem": "EF_SAK",
                "meta": {
                    "representerer": {"enhet": {"nr": "4490"}}
                }
            }
            """.trimIndent()
        val json = jsonMapper.writeValueAsString(request)

        assertEquals(jsonMapper.readTree(expectedJson), jsonMapper.readTree(json))
        assertEquals(request, jsonMapper.readValue<OpprettOppgaveV2Request>(json))
    }

    @Test
    fun `skal utelate valgfrie felter og la oppgave velge standardverdier`() {
        val request =
            OpprettOppgaveV2Request(
                kategorisering = kategorisering,
                bruker = Bruker("12345678901", Brukertype.PERSON),
            )
        val expectedJson =
            """
            {
                "kategorisering": {
                    "tema": {"kode": "ENF"},
                    "oppgavetype": {"kode": "GOD_VED"}
                },
                "bruker": {"ident": "12345678901", "type": "PERSON"}
            }
            """.trimIndent()
        val json = jsonMapper.writeValueAsString(request)

        assertEquals(jsonMapper.readTree(expectedJson), jsonMapper.readTree(json))
        assertEquals(request, jsonMapper.readValue<OpprettOppgaveV2Request>(json))
    }

    @Test
    fun `skal kunne opprette med arkivreferanse uten bruker`() {
        val request =
            OpprettOppgaveV2Request(
                kategorisering = kategorisering,
                arkivreferanse = Arkivreferanse(journalpostId = "456"),
            )
        val json = jsonMapper.writeValueAsString(request)

        assertEquals(jsonMapper.readTree("""{"journalpostId":"456"}"""), jsonMapper.readTree(json)["arkivreferanse"])
        assertEquals(request, jsonMapper.readValue<OpprettOppgaveV2Request>(json))
    }

    @Test
    fun `skal bevare eksplisitt tomme nokkelord`() {
        val request =
            OpprettOppgaveV2Request(
                kategorisering = kategorisering,
                bruker = Bruker("12345678901", Brukertype.PERSON),
                nokkelord = emptySet(),
            )
        val json = jsonMapper.writeValueAsString(request)

        assertEquals(jsonMapper.readTree("[]"), jsonMapper.readTree(json)["nokkelord"])
        assertEquals(request, jsonMapper.readValue<OpprettOppgaveV2Request>(json))
    }

    @Test
    fun `skal kunne skrive og lese forespørsel uten bruker eller arkivreferanse`() {
        val request = OpprettOppgaveV2Request(kategorisering = kategorisering)
        val json = jsonMapper.writeValueAsString(request)

        assertEquals(request, jsonMapper.readValue<OpprettOppgaveV2Request>(json))
    }
}
