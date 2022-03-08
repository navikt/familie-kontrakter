package no.nav.familie.kontrakter.ef.felles

data class FrittståendeBrevDto(val personIdent: String,
                               val eksternFagsakId: Long,
                               val brevtype: FrittståendeBrevType,
                               val fil: ByteArray,
                               val journalførendeEnhet: String,
                               val saksbehandlerIdent: String)

enum class FrittståendeBrevType(val tittel: String) {
    MANGELBREV_OVERGANGSSTØNAD("Innhenting av opplysninger"),
    MANGELBREV_BARNETILSYN("Innhenting av opplysninger"),
    MANGELBREV_SKOLEPENGER("Innhenting av opplysninger"),
    INFOBREV_OVERGANGSSTØNAD("Infobrev overgangsstønad"),
    INFOBREV_BARNETILSYN("Infobrev barnetilsyn"),
    INFOBREV_SKOLEPENGER("Infobrev skolepenger"),
    SANKSJONSBREV_OVERGANGSTØNAD("Varsel om sanksjon"),
    SANKSJONSBREV_BARNETILSYN("Varsel om sanksjon"),
    SANKSJONSBREV_SKOLEPENGER("Varsel om sanksjon"),
}