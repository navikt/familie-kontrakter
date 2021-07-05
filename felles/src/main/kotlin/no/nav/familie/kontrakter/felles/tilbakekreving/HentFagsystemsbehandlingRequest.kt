package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.Språkkode
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Pattern

data class HentFagsystemsbehandlingRequest(val eksternFagsakId: String,
                                           val ytelsestype: Ytelsestype,
                                           val eksternId: String) {
}

data class HentFagsystemsbehandlingRespons(val eksternFagsakId: String,
                                           val ytelsestype: Ytelsestype,
                                           val eksternId: String,
                                           val personIdent: String,
                                           val språkkode: Språkkode = Språkkode.NB,
                                           val enhetId: String,
                                           val enhetsnavn: String,
                                           @field:Pattern(regexp = "(^$|.{11})", message = "PersonIdent er ikke riktig")
                                           val revurderingsvedtaksdato: LocalDate,
                                           @field:Valid
                                           val verge: Verge? = null,
                                           @field:Valid
                                           val faktainfo: Faktainfo)
