package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent
import java.time.LocalDate

data class OpprettTilbakekrevingRequest(val fagsystem: String,
                                        val eksternFagsakId: String,
                                        val personIdent: PersonIdent,
                                        val eksternId: String, // Fagsystemreferanse til behandlingen, må være samme id som brukes mot datavarehus og økonomi
                                        val behandlingType: BehandlingType? = BehandlingType.TILBAKEKREVING,
                                        val manueltOpprettet: Boolean,
                                        val språkkode: String? = "NB",
                                        val enhetId: String,
                                        val enhetsnavn: String,
                                        val varselTekst: String,
                                        val feilutbetaltePerioder: FeilutbetaltePerioder,
                                        val revurderingVedtakDato: LocalDate,
                                        val verge: Verge? = null)
