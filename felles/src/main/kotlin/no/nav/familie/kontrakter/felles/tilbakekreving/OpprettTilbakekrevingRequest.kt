package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent

data class OpprettTilbakekrevingRequest(val fagsytem: String,
                                        val eksternFagsakId: String,
                                        val personIdent: PersonIdent,
                                        val aktoerId: Long, // Brukes aktoerId kanskje istedenfor personIdent??
                                        val henvisning: String, // BehandlingId/UUID til BA/EF/KA
                                        val behandlingType: BehandlingType,
                                        val spraakKode: String? = "NB",
                                        val enhetId: String,
                                        val enhetNavn: String,
                                        val verge: Verge? = null)
