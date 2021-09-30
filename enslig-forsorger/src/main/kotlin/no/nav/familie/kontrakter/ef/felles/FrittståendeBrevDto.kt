package no.nav.familie.kontrakter.ef.felles

import java.util.UUID

data class FrittståendeBrevDto(val personIdent: UUID,
                               val fagsakId: UUID,
                               val stønadType: StønadType,
                               val dokumentTittel: DokumentTypeFrittståendeBrev,
                               val fil: ByteArray,
                               val journalførendeEnhet: String)

enum class DokumentTypeFrittståendeBrev(val tittel: String) {
    MANGELBREV_OVERGANGSSTØNAD("Mangelbrev overgangsstønad"),
    MANGELBREV_BARNETILSYN("Mangelbrev barnetilsyn"),
    MANGELBREV_SKOLEPENGER("Mangelbrev skolepenger"),
    INFOBREV_OVERGANGSSTØNAD("Infobrev overgangsstønad"),
    INFOBREV_BARNETILSYN("Infobrev barnetilsyn"),
    INFOBREV_SKOLEPENGER("Infobrev skolepenger"),
}