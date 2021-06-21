package no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.kontrakter.ef.felles.BehandlingType
import no.nav.familie.kontrakter.ef.felles.StønadType
import java.time.ZonedDateTime
import java.util.UUID

data class BehandlingStatistikkDto(
        val behandlingId: UUID,
        val personIdent: String,
        val gjeldendeSaksbehandlerId: String,
        val saksnummer: String,
        val hendelseTidspunkt: ZonedDateTime,
        val søknadstidspunkt: ZonedDateTime? = null,
        val hendelse: Hendelse,
        val behandlingResultat: String? = null,
        val resultatBegrunnelse: String? = null,
        val opprettetEnhet: String,
        val ansvarligEnhet: String,
        val strengtFortroligAdresse: Boolean,
        val stønadstype: StønadType,
        val behandlingstype: BehandlingType
)

enum class Hendelse {
    MOTTATT,
    PÅBEGYNT,
    VEDTATT,
    BESLUTTET,
    FERDIG
}