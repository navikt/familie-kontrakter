package no.nav.familie.kontrakter.felles.oppgave

import java.time.LocalDate

data class OpprettOppgave(
    val ident: OppgaveIdent,
    val enhetsnummer: String?,
    val saksId: String?,
    val journalpostId: String? = null,
    val tema: Tema,
    val oppgavetype: Oppgavetype,
    val behandlingstema: String?,
    val fristFerdigstillelse: LocalDate,
    val aktivFra: LocalDate = LocalDate.now(),
    val beskrivelse: String
)

data class OppgaveIdent(val ident: String, val type: IdentType)

enum class IdentType {
    Aktør, Organisasjon
}

enum class Oppgavetype(val value: String) {
    BehandleSak("BEH_SAK"),
    Journalføring("JFR")
}