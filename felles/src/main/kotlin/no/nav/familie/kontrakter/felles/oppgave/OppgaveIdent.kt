package no.nav.familie.kontrakter.felles.oppgave

data class OppgaveIdentV2(val ident: String, val identgruppe: IdentGruppe)

enum class IdentGruppe {
    AKTORID,
    FOLKEREGISTERIDENT,
    NPID,
    ORGNR,
    SAMHANDLERNR
}