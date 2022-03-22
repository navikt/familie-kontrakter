package no.nav.familie.kontrakter.ef.felles

import no.nav.familie.kontrakter.felles.ef.StønadType

data class FrittståendeBrevDto(val personIdent: String,
                               val eksternFagsakId: Long,
                               val stønadType: StønadType? = null, // TODO: skal settes til non-nullable når deprecated verdier er brevtyper er fjernet
                               val brevtype: FrittståendeBrevType,
                               val fil: ByteArray,
                               val journalførendeEnhet: String,
                               val saksbehandlerIdent: String)

enum class FrittståendeBrevType(val tittel: String) {
    @Deprecated("Skal erstattes av stønads-agnostiske typer")
    MANGELBREV_OVERGANGSSTØNAD("Innhenting av opplysninger"),

    @Deprecated("Skal erstattes av stønads-agnostiske typer")
    MANGELBREV_BARNETILSYN("Innhenting av opplysninger"),

    @Deprecated("Skal erstattes av stønads-agnostiske typer")
    MANGELBREV_SKOLEPENGER("Innhenting av opplysninger"),

    @Deprecated("Skal erstattes av stønads-agnostiske typer")
    INFOBREV_OVERGANGSSTØNAD("Infobrev overgangsstønad"),

    @Deprecated("Skal erstattes av stønads-agnostiske typer")
    INFOBREV_BARNETILSYN("Infobrev barnetilsyn"),

    @Deprecated("Skal erstattes av stønads-agnostiske typer")
    INFOBREV_SKOLEPENGER("Infobrev skolepenger"),

    @Deprecated("Skal erstattes av stønads-agnostiske typer")
    SANKSJONSBREV_OVERGANGSTØNAD("Varsel om sanksjon"),

    @Deprecated("Skal erstattes av stønads-agnostiske typer")
    SANKSJONSBREV_BARNETILSYN("Varsel om sanksjon"),

    @Deprecated("Skal erstattes av stønads-agnostiske typer")
    SANKSJONSBREV_SKOLEPENGER("Varsel om sanksjon"),


    INFORMASJONSBREV("Informasjonsbrev"),
    INNHENTING_AV_OPPLYSNINGER("Innhenting av opplysninger"),
    VARSEL_OM_AKTIVITETSPLIKT("Varsel om aktivitetsplikt"),
    VARSEL_OM_SANKSJON("Varsel om sanksjon"),
}