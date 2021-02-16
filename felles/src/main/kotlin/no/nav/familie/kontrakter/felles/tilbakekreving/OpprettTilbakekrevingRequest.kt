package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.NotBlank

data class OpprettTilbakekrevingRequest(val fagsystem: Fagsystem,
                                        val ytelsestype: Ytelsestype,
                                        val eksternFagsakId: String,
                                        @field:Valid
                                        val personIdent: PersonIdent,
                                        val eksternId: String, // Fagsystemreferanse til behandlingen, må være samme id som brukes mot datavarehus og økonomi
                                        val behandlingstype: Behandlingstype? = Behandlingstype.TILBAKEKREVING,
                                        val manueltOpprettet: Boolean,
                                        val språkkode: Språkkode = Språkkode.NB,
                                        val enhetId: String,
                                        val enhetsnavn: String,
                                        @field:Valid
                                        val varsel: Varsel?,
                                        val revurderingsvedtaksdato: LocalDate,
                                        @field:Valid
                                        val verge: Verge? = null,
                                        @field:Valid
                                        val faktainfo: Faktainfo)

