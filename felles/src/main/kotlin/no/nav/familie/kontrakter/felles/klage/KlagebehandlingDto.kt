package no.nav.familie.kontrakter.felles.klage

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class KlagebehandlingDto(
    val id: UUID,
    val fagsakId: UUID,
    val årsak: Årsak,
    val status: BehandlingStatus,
    val resultat: BehandlingResultat?,
    val opprettet: LocalDateTime,
    val vedtaksdato: LocalDateTime,
    val mottattDato: LocalDate
)
