package no.nav.familie.kontrakter.felles.oppgave

data class OppgaveIdentV2(val ident: String?, val gruppe: IdentGruppe?)

enum class IdentGruppe {
    AKTORID,
    @Deprecated("Erstates av AKTOERID")
    AKTOERID,
    FOLKEREGISTERIDENT,
    NPID,
    ORGNR,
    SAMHANDLERNR
}