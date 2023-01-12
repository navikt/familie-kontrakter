package no.nav.familie.kontrakter.felles.oppgave

import no.nav.familie.kontrakter.felles.Behandlingstema
import no.nav.familie.kontrakter.felles.Tema
import java.time.LocalDate
import java.time.LocalDateTime

data class FinnOppgaveRequest(
    val tema: Tema,
    val behandlingstema: Behandlingstema? = null,
    val behandlingstype: Behandlingstype? = null,
    val erUtenMappe: Boolean? = null,
    val oppgavetype: Oppgavetype? = null,
    val enhet: String? = null,
    val saksbehandler: String? = null,
    val aktørId: String? = null,
    val journalpostId: String? = null,
    val saksreferanse: String? = null,
    val tilordnetRessurs: String? = null,
    val tildeltRessurs: Boolean? = null,
    val opprettetFomTidspunkt: LocalDateTime? = null,
    val opprettetTomTidspunkt: LocalDateTime? = null,
    val fristFomDato: LocalDate? = null,
    val fristTomDato: LocalDate? = null,
    val aktivFomDato: LocalDate? = null,
    val aktivTomDato: LocalDate? = null,
    val enhetsmappe: Enhetsmappe? = null,
    val mappeId: Long? = null,
    val limit: Long? = null,
    val offset: Long? = null
)
