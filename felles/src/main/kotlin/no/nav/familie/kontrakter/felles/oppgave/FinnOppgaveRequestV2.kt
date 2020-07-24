package no.nav.familie.kontrakter.felles.oppgave

import java.time.LocalDate
import java.time.LocalDateTime

data class FinnOppgaveRequestV2(val tema: Tema,
                                val behandlingstema: Behandlingstema? = null,
                                val oppgavetype: Oppgavetype? = null,
                                val enhet: String? = null,
                                val saksbehandler: String? = null,
                                val journalpostId: String? = null,
                                val tilordnetRessurs: String? = null,
                                val tildeltRessurs: Boolean? = null,
                                val opprettetFomTidspunkt: LocalDateTime? = null,
                                val opprettetTomTidspunkt: LocalDateTime? = null,
                                val fristFomDato: LocalDate? = null,
                                val fristTomDato: LocalDate? = null,
                                val aktivFomDato: LocalDate? = null,
                                val aktivTomDato: LocalDate? = null,
                                val limit: Long? = null,
                                val offset: Long? = null)
