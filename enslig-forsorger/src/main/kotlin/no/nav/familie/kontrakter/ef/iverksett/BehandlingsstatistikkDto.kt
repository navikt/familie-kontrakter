package no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.kontrakter.ef.felles.AvslagÅrsak
import no.nav.familie.kontrakter.ef.felles.BehandlingType
import no.nav.familie.kontrakter.ef.felles.BehandlingÅrsak
import no.nav.familie.kontrakter.felles.ef.StønadType
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.UUID

data class BehandlingsstatistikkDto(
    val behandlingId: UUID,
    val eksternBehandlingId: Long,
    val personIdent: String,
    val gjeldendeSaksbehandlerId: String,
    val beslutterId: String?,
    val eksternFagsakId: Long,
    val behandlingOpprettetTidspunkt: ZonedDateTime? = null,
    val hendelseTidspunkt: ZonedDateTime,
    val hendelse: Hendelse,
    val behandlingResultat: String? = null,
    val resultatBegrunnelse: String? = null,
    val opprettetEnhet: String,
    val ansvarligEnhet: String,
    val strengtFortroligAdresse: Boolean,
    val stønadstype: StønadType,
    val behandlingstype: BehandlingType,
    val behandlingÅrsak: BehandlingÅrsak,
    val henvendelseTidspunkt: ZonedDateTime? = null,
    val relatertEksternBehandlingId: Long?,
    val relatertBehandlingId: UUID?,
    val behandlingMetode: BehandlingMetode?,
    val kravMottatt: LocalDate? = null,
    val årsakRevurdering: ÅrsakRevurderingDto? = null,
    val avslagÅrsak: AvslagÅrsak? = null
)

enum class Hendelse {
    MOTTATT,
    PÅBEGYNT,
    VENTER,
    VEDTATT,
    BESLUTTET,
    HENLAGT,
    FERDIG
}

enum class BehandlingMetode {
    MANUELL,
    AUTOMATISK,
    BATCH
}
