package no.nav.familie.kontrakter.felles.oppgave

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.Behandlingstema
import no.nav.familie.kontrakter.felles.Tema
import no.nav.familie.kontrakter.felles.objectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class FinnOppgaveRequestTest{

    @Test
    fun `Kan konvertere fra json til FinnOppgaveRequest`(){

        val finnOppgaveRequestString = """
            {
                "tema": "BAR",
                "behandlingstema": "Barnetrygd",
                "behandlingstype": "NASJONAL",
                "erUtenMappe": false,
                "oppgavetype": "BehandleSak",
                "enhet": "1234",
                "saksbehandler": "John Smith",
                "aktørId": "12345678",
                "journalpostId": "J123456",
                "saksreferanse": "S123456",
                "tilordnetRessurs": "Jane Smith",
                "tildeltRessurs": true,
                "opprettetFomTidspunkt": "2000-10-31T01:30:00.000-05:00",
                "opprettetTomTidspunkt": "2000-10-31T01:30:00.000-05:00",
                "fristFomDato": "2000-10-31",
                "fristTomDato": "2000-10-31",
                "aktivFomDato": "2000-10-31",
                "aktivTomDato": "2000-10-31",
                "enhetsmappe": "SøknaderKlarTilBehandling",
                "mappeId": 12345,
                "limit": 10,
                "offset": 0
            }
        """.trimIndent()

        Assertions.assertDoesNotThrow {
            objectMapper.readValue<FinnOppgaveRequest>(finnOppgaveRequestString)
        }
    }
}
