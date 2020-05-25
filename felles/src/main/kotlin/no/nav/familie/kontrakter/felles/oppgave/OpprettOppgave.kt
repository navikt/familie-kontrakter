package no.nav.familie.kontrakter.felles.oppgave

import java.time.LocalDate

data class OpprettOppgave(
    val ident: OppgaveIdent?,
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
    val behandlingstype: String? = null
)

data class OppgaveIdent(val ident: String, val type: IdentType)

enum class IdentType {
    Aktør, Organisasjon
}

enum class Oppgavetype(val value: String) {
    BehandleSak("BEH_SAK"),
    Journalføring("JFR"),
    GodkjenneVedtak("GOD_VED"),
    BehandleUnderkjentVedtak("BEH_UND_VED"),
    Fordeling("FDR")
}

enum class Behandlingstema(val value: String) {
    Barnetrygd("ab0270"),
    BarnetrygdEØS("ab0058"),
    OrdinærBarnetrygd("ab0180"),
    UtvidetBarnetrygd("ab0096")
}

enum class Behandlingstype(val value: String) {
    Utland("ae0106")
}

enum class OppgavePrioritet() {
    HOY,
    NORM,
    LAV;
}