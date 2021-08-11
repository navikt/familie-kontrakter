package no.nav.familie.kontrakter.felles.tilbakekreving

import java.util.UUID

data class OpprettTilbakekrevingRevurderingRequest(val originalBehandlingEksternBrukId: UUID,
                                                   val årsakstype:Behandlingsårsakstype)