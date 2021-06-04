package  no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.ef.iverksett.infrastruktur.json.BarnDto
import no.nav.familie.kontrakter.ef.felles.BehandlingType
import no.nav.familie.kontrakter.ef.felles.BehandlingÅrsak
import no.nav.familie.kontrakter.ef.felles.OpphørÅrsak
import no.nav.familie.kontrakter.ef.felles.RegelId
import no.nav.familie.kontrakter.ef.felles.StønadType
import no.nav.familie.kontrakter.ef.felles.Vedtaksresultat
import no.nav.familie.kontrakter.ef.felles.VilkårType
import no.nav.familie.kontrakter.ef.felles.Vilkårsresultat
import java.time.LocalDate
import java.util.UUID

data class IverksettDto(
        val fagsak: FagsakdetaljerDto,
        val behandling: BehandlingsdetaljerDto,
        val søker: SøkerDto,
        val vedtak: VedtaksdetaljerDto,
)

data class SøkerDto(
        val personIdent: String,
        val barn: List<BarnDto> = emptyList(),
        val tilhørendeEnhet: String,
        val adressebeskyttelse: AdressebeskyttelseGradering? = null,
)

data class FagsakdetaljerDto(
        val fagsakId: UUID,
        val eksternId: Long,
        val stønadstype: StønadType
)

data class BehandlingsdetaljerDto(
        val behandlingId: UUID,
        val forrigeBehandlingId: UUID? = null,
        val eksternId: Long,
        val behandlingType: BehandlingType,
        val behandlingÅrsak: BehandlingÅrsak,
        val vilkårsvurderinger: List<VilkårsvurderingDto> = emptyList()
)


data class VedtaksdetaljerDto(
        val resultat: Vedtaksresultat,
        val vedtaksdato: LocalDate,
        val opphørÅrsak: OpphørÅrsak?,
        val saksbehandlerId: String,
        val beslutterId: String,
        val tilkjentYtelse: TilkjentYtelseDto,
)

data class VilkårsvurderingDto(
        val vilkårType: VilkårType,
        val resultat: Vilkårsresultat,
        val delvilkårsvurderinger: List<DelvilkårsvurderingDto> = emptyList()
)

data class DelvilkårsvurderingDto(
        val resultat: Vilkårsresultat,
        val vurderinger: List<VurderingDto> = emptyList()
)

data class VurderingDto(
        val regelId: RegelId,
        val svar: SvarId? = null,
        val begrunnelse: String? = null
)

enum class AdressebeskyttelseGradering {
    STRENGT_FORTROLIG,
    STRENGT_FORTROLIG_UTLAND,
    FORTROLIG,
    UGRADERT
}


enum class IverksettStatus {
    SENDT_TIL_OPPDRAG,
    FEILET_MOT_OPPDRAG,
    OK_MOT_OPPDRAG,
    JOURNALFØRT,
    OK,
    IKKE_PÅBEGYNT
}

