package no.nav.familie.kontrakter.felles.klage

import java.time.LocalDateTime
import java.util.UUID

data class KlagebehandlingDto(
    val id: UUID,
    val fagsakId: UUID,
    val årsak: String,
    val status: BehandlingStatus,
    val sistEndret: LocalDateTime,
    val resultat: BehandlingResultat?,
    val opprettet: LocalDateTime,
    val vedtaksdato: LocalDateTime? = null,
)
