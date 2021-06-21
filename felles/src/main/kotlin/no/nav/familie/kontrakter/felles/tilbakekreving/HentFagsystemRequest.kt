package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.Språkkode
import java.time.LocalDate
import javax.validation.Valid

data class HentFagsystemRequest(val eksternFagsakId: String,
                                val ytelsestype: Ytelsestype,
                                val eksternId: String) {
}

data class HentFagsystemRespons(val eksternFagsakId: String,
                                val ytelsestype: Ytelsestype,
                                val eksternId: String,
                                val personIdent: String,
                                val språkkode: Språkkode = Språkkode.NB,
                                val enhetId: String,
                                val enhetsnavn: String,
                                val saksbehandlerIdent: String,
                                val revurderingsvedtaksdato: LocalDate,
                                @field:Valid
                                val verge: Verge? = null,
                                @field:Valid
                                val faktainfo: Faktainfo)
