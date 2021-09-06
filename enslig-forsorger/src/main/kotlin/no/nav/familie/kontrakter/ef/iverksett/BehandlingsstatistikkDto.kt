package no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.kontrakter.ef.felles.BehandlingType
import no.nav.familie.kontrakter.ef.felles.StønadType
import java.time.ZonedDateTime
import java.util.UUID

data class BehandlingsstatistikkDto(
        val behandlingId: UUID,
        val personIdent: String,
        val gjeldendeSaksbehandlerId: String,
        val eksternFagsakId: String,
        val hendelseTidspunkt: ZonedDateTime,
        @Deprecated("bruk henvendelseTidspunkt") val søknadstidspunkt: ZonedDateTime? = null,
        val hendelse: Hendelse,
        val behandlingResultat: String? = null,
        val resultatBegrunnelse: String? = null,
        val opprettetEnhet: String,
        val ansvarligEnhet: String,
        val strengtFortroligAdresse: Boolean,
        val stønadstype: StønadType,
        val behandlingstype: BehandlingType,
        val henvendelseTidspunkt: ZonedDateTime? = null, // erstatter søknadstidspunkt
        val relatertBehandlingId: UUID?
)

enum class Hendelse {
    MOTTATT,
    PÅBEGYNT,
    VEDTATT,
    BESLUTTET,
    FERDIG
}