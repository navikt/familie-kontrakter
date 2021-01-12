package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent

data class OpprettTilbakekrevingRequest(val fagsystem: String,
                                        val eksternFagsakId: String,
                                        val personIdent: PersonIdent,
                                        val aktørId: Long, // Brukes aktoerId kanskje istedenfor personIdent??
                                        val henvisning: String, // BehandlingId/UUID til BA/EF/KA
                                        val behandlingType: BehandlingType,
                                        val språkkode: String? = "NB",
                                        val enhetId: String,
                                        val enhetsnavn: String,
                                        val verge: Verge? = null)
