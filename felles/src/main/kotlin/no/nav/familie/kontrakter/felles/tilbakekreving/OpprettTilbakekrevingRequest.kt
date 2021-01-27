package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent
import java.time.LocalDate
import javax.validation.constraints.NotBlank

data class OpprettTilbakekrevingRequest(val ytelsestype: Ytelsestype,
                                        val eksternFagsakId: String,
                                        val personIdent: PersonIdent,
                                        val eksternId: String, // Fagsystemreferanse til behandlingen, må være samme id som brukes mot datavarehus og økonomi
                                        val behandlingType: BehandlingType? = BehandlingType.TILBAKEKREVING,
                                        val manueltOpprettet: Boolean,
                                        @field:NotBlank(message = "Mangler språkkode")
                                        val språkkode: String? = "NB",
                                        val enhetId: String,
                                        val enhetsnavn: String,
                                        val varsel: Varsel?,
                                        val revurderingVedtakDato: LocalDate,
                                        val verge: Verge? = null)
