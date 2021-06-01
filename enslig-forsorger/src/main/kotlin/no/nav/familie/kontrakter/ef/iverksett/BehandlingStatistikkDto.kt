package no.nav.familie.kontrakter.ef.iverksett

import java.time.ZonedDateTime
import java.util.UUID

data class BehandlingStatistikkDto(
        val behandlingId: UUID,
        val aktorId: String,
        val saksbehandlerId: String,
        val saksnummer: String,
        val registrertTid: ZonedDateTime,
        val endretTid: ZonedDateTime,
        val hendelse: Hendelse
)

enum class Hendelse {
    MOTTATT,
    PÅBEGYNT,
    VEDTATT,
    BESLUTTET,
    FERDIG
}