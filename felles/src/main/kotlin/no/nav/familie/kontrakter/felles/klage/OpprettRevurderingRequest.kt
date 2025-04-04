package no.nav.familie.kontrakter.felles.klage

import java.util.UUID

data class OpprettRevurderingRequest(
    val klagebehandlingId: UUID,
    val eksternFagsakId: String,
)
