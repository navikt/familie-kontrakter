package no.nav.familie.kontrakter.ef.felles

import no.nav.familie.kontrakter.ef.iverksett.Brevmottaker
import no.nav.familie.kontrakter.felles.ef.StønadType

data class FrittståendeBrevDto(
    val personIdent: String,
    val eksternFagsakId: Long,
    val stønadType: StønadType,
    val brevtype: FrittståendeBrevType,
    val fil: ByteArray,
    val journalførendeEnhet: String,
    val saksbehandlerIdent: String,
    val mottakere: List<Brevmottaker>? = null
)

enum class FrittståendeBrevType(val tittel: String) {
    INFORMASJONSBREV("Informasjonsbrev"),
    INNHENTING_AV_OPPLYSNINGER("Innhenting av opplysninger"),
    VARSEL_OM_AKTIVITETSPLIKT("Varsel om aktivitetsplikt"),
    VARSEL_OM_SANKSJON("Varsel om sanksjon"),
    INNHENTING_AV_KARAKTERUTSKRIFT_HOVEDPERIODE("Innhenting av karakterutskrift (hovedperiode)"),
    INNHENTING_AV_KARAKTERUTSKRIFT_UTVIDET_PERIODE("Innhenting av karakterutskrift (utvidet periode)"),
    BREV_OM_SVARTID_KLAGE("Brev om svartid - klage"),
    BREV_OM_FORLENGET_SVARTID_KLAGE("Brev om forlenget svartid - klage")
}
