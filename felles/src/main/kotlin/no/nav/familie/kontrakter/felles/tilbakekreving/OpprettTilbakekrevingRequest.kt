package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent
import java.time.LocalDate

data class OpprettTilbakekrevingRequest(val fagsystem: String,
                                        val eksternFagsakId: String,
                                        val personIdent: PersonIdent,
                                        val henvisning: String, // BehandlingId/UUID til BA/EF/KA
                                        val behandlingType: BehandlingType,
                                        val språkkode: String? = "NB",
                                        val enhetId: String,
                                        val enhetsnavn: String,
                                        val varselTekst: String,
                                        val feilutbetaltePerioder: FeilutbetaltePerioder,
                                        val revurderingVedtakDato:LocalDate,
                                        val verge: Verge? = null)
