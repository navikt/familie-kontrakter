package no.nav.familie.kontrakter.felles.oppgave

import java.time.LocalDate

data class OpprettOppgave(
    val ident: OppgaveIdent,
    val enhetsnummer: String?,
    val saksId: String,
    val tema: Tema,
    val behandlingstema: String?,
    val fristFerdigstillelse: LocalDate,
    val aktivFra: LocalDate = LocalDate.now()
)

data class OppgaveIdent(val ident: String, val type: IdentType)

enum class IdentType {
    Aktør, Organisasjon
}