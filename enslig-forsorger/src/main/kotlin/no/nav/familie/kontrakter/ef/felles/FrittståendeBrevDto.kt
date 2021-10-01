package no.nav.familie.kontrakter.ef.felles

data class FrittståendeBrevDto(val personIdent: String,
                               val eksternFagsakId: Long,
                               val stønadType: StønadType,
                               val brevtype: FrittståendeBrevType,
                               val fil: ByteArray,
                               val journalførendeEnhet: String,
                               val saksbehandlerIdent: String)

enum class FrittståendeBrevType(val tittel: String) {
    MANGELBREV_OVERGANGSSTØNAD("Mangelbrev overgangsstønad"),
    MANGELBREV_BARNETILSYN("Mangelbrev barnetilsyn"),
    MANGELBREV_SKOLEPENGER("Mangelbrev skolepenger"),
    INFOBREV_OVERGANGSSTØNAD("Infobrev overgangsstønad"),
    INFOBREV_BARNETILSYN("Infobrev barnetilsyn"),
    INFOBREV_SKOLEPENGER("Infobrev skolepenger"),
}