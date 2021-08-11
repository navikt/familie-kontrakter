package no.nav.familie.kontrakter.felles.tilbakekreving

import java.util.UUID

data class OpprettTilbakekrevingRevurderingRequest(val originalBehandlingUUID: UUID,
                                                   val årsakstype:Behandlingsårsakstype)