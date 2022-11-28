package no.nav.familie.kontrakter.felles.oppgave

import com.fasterxml.jackson.annotation.JsonFormat
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = datoTidformat)
    val opprettetFomTidspunkt: LocalDateTime? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = datoTidformat)
    val opprettetTomTidspunkt: LocalDateTime? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = datoformat)
    val fristFomDato: LocalDate? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = datoformat)
    val fristTomDato: LocalDate? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = datoformat)
    val aktivFomDato: LocalDate? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = datoformat)
    val aktivTomDato: LocalDate? = null,
    val enhetsmappe: Enhetsmappe? = null,
    val mappeId: Long? = null,
    val limit: Long? = null,
    val offset: Long? = null
)

const val datoTidformat = "dd-MM-yyyy hh:mm:ss"
const val datoformat = "dd-MM-yyyy"
