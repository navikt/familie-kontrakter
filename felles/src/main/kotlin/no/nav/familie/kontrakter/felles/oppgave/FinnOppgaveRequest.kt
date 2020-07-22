package no.nav.familie.kontrakter.felles.oppgave

data class FinnOppgaveRequest(val tema: String? = null,
                              val behandlingstema: String? = null,
                              val oppgavetype: String? = null,
                              val enhet: String? = null,
                              val saksbehandler: String? = null,
                              val journalpostId: String? = null,
                              val opprettetFomTidspunkt: String? = null,
                              val opprettetTomTidspunkt: String? = null,
                              val fristFomDato: String? = null,
                              val fristTomDato: String? = null,
                              val aktivFomDato: String? = null,
                              val aktivTomDato: String? = null,
                              val limit: Long? = null,
                              val offset: Long? = null)