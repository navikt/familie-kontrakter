package no.nav.familie.kontrakter.ef.felles

import no.nav.familie.kontrakter.ef.iverksett.Brevmottaker
import no.nav.familie.kontrakter.felles.ef.StønadType

data class FrittståendeBrevDto(
    val personIdent: String,
    val eksternFagsakId: Long,
    val stønadType: StønadType,
    @Deprecated("Skal erstattes av tittel")
    val brevtype: FrittståendeBrevType? = null,
    val tittel: String,
    val fil: ByteArray,
    val journalførendeEnhet: String,
    val saksbehandlerIdent: String,
    val mottakere: List<Brevmottaker>? = null,
)

enum class FrittståendeBrevType(
    val tittel: String,
) {
    INFORMASJONSBREV("Informasjonsbrev"),
    INNHENTING_AV_OPPLYSNINGER("Innhenting av opplysninger"),
    VARSEL_OM_AKTIVITETSPLIKT("Varsel om aktivitetsplikt"),
    VARSEL_OM_SANKSJON("Varsel om sanksjon"),
    INNHENTING_AV_KARAKTERUTSKRIFT_HOVEDPERIODE("Innhenting av karakterutskrift"),
    INNHENTING_AV_KARAKTERUTSKRIFT_UTVIDET_PERIODE("Innhenting av karakterutskrift"),
    BREV_OM_SVARTID_KLAGE("Brev om svartid - klage"),
    BREV_OM_FORLENGET_SVARTID("Brev om forlenget svartid"),
    BREV_OM_FORLENGET_SVARTID_KLAGE("Brev om forlenget svartid - klage"),
    INFORMASJONSBREV_TRUKKET_SØKNAD("Informasjonsbrev - bruker har trukket søknad"),
    VARSEL_UTESTENGELSE("Varsel om utestengelse"),
    VEDTAK_UTESTENGELSE("Vedtak om utestengelse"),
}
