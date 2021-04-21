package no.nav.familie.kontrakter.felles.oppgave

import no.nav.familie.kontrakter.felles.Tema
import java.time.LocalDate

@Deprecated("Bruk OpprettOppgaveRequest")
data class OpprettOppgave(val ident: OppgaveIdent?,
                          val enhetsnummer: String?,
                          val saksId: String?,
                          val journalpostId: String? = null,
                          val tema: Tema,
                          val oppgavetype: Oppgavetype,
                          val behandlingstema: String?,
                          val tilordnetRessurs: String? = null,
                          val fristFerdigstillelse: LocalDate,
                          val aktivFra: LocalDate = LocalDate.now(),
                          val beskrivelse: String,
                          val prioritet: OppgavePrioritet = OppgavePrioritet.NORM,
                          val behandlingstype: String? = null)

@Deprecated("Bruk OppgaveIdentV2 og IdentGruppe")
data class OppgaveIdent(val ident: String, val type: IdentType)

@Deprecated("Bruk OppgaveIdentV2 og IdentGruppe")
enum class IdentType {
    Aktør,
    Organisasjon
}