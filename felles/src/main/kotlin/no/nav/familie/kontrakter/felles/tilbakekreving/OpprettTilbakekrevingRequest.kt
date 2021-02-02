package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.NotBlank

data class OpprettTilbakekrevingRequest(val ytelsestype: Ytelsestype,
                                        val eksternFagsakId: String,
                                        @field:Valid
                                        val personIdent: PersonIdent,
        // Fagsystemreferanse til behandlingen, må være samme id som brukes mot datavarehus og økonomi
                                        val eksternId: String,
                                        val behandlingstype: Behandlingstype? = Behandlingstype.TILBAKEKREVING,
                                        val manueltOpprettet: Boolean,
                                        @field:NotBlank(message = "Mangler språkkode")
                                        val språkkode: String? = "NB",
                                        val enhetId: String,
                                        val enhetsnavn: String,
                                        @field:Valid
                                        val varsel: Varsel?,
                                        val revurderingsvedtaksdato: LocalDate,
                                        @field:Valid
                                        val verge: Verge? = null)
