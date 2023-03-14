package no.nav.familie.kontrakter.felles.tilbakekreving

import jakarta.validation.Valid
import jakarta.validation.constraints.Pattern
import no.nav.familie.kontrakter.felles.Fagsystem
import no.nav.familie.kontrakter.felles.Regelverk
import no.nav.familie.kontrakter.felles.Språkkode
import java.time.LocalDate

data class OpprettTilbakekrevingRequest(
    val fagsystem: Fagsystem,
    val regelverk: Regelverk? = null,
    val ytelsestype: Ytelsestype,
    val eksternFagsakId: String,
    @field:Pattern(regexp = "(^$|.{11})", message = "PersonIdent er ikke riktig")
    val personIdent: String,
    // Fagsystemreferanse til behandlingen, må være samme id som brukes mot datavarehus og økonomi
    val eksternId: String,
    val behandlingstype: Behandlingstype? = Behandlingstype.TILBAKEKREVING,
    val manueltOpprettet: Boolean,
    val språkkode: Språkkode = Språkkode.NB,
    val enhetId: String,
    val enhetsnavn: String,
    val saksbehandlerIdent: String,
    @field:Valid
    val varsel: Varsel?,
    val revurderingsvedtaksdato: LocalDate,
    @field:Valid
    val verge: Verge? = null,
    @field:Valid
    val faktainfo: Faktainfo,
    @field:Valid
    val institusjon: Institusjon? = null,
    @field:Valid
    val manuelleBrevmottakere: Set<Brevmottaker> = emptySet()
) {

    init {
        if (manueltOpprettet) {
            require(varsel == null) { "Kan ikke opprette manuelt behandling med varsel" }
        }
    }
}
