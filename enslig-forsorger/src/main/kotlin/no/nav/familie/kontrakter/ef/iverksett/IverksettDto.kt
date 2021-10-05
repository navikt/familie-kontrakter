package  no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.kontrakter.ef.felles.BehandlingType
import no.nav.familie.kontrakter.ef.felles.BehandlingÅrsak
import no.nav.familie.kontrakter.ef.felles.OpphørÅrsak
import no.nav.familie.kontrakter.ef.felles.RegelId
import no.nav.familie.kontrakter.ef.felles.StønadType
import no.nav.familie.kontrakter.ef.felles.Vedtaksresultat
import no.nav.familie.kontrakter.ef.felles.VilkårType
import no.nav.familie.kontrakter.ef.felles.Vilkårsresultat
import no.nav.familie.kontrakter.felles.tilbakekreving.Periode
import no.nav.familie.kontrakter.felles.tilbakekreving.Tilbakekrevingsvalg
import java.math.BigDecimal
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
        val vilkårsvurderinger: List<VilkårsvurderingDto> = emptyList(),
        val aktivitetspliktInntrefferDato: LocalDate? = null
)


data class VedtaksdetaljerDto(
        val resultat: Vedtaksresultat,
        val vedtaksdato: LocalDate,
        val opphørÅrsak: OpphørÅrsak?,
        val saksbehandlerId: String,
        val beslutterId: String,
        val tilkjentYtelse: TilkjentYtelseDto?,
        val vedtaksperioder: List<VedtaksperiodeDto> = emptyList(),
        val tilbakekreving: TilbakekrevingDto? = null
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

data class VedtaksperiodeDto(
        val fraOgMed: LocalDate,
        val tilOgMed: LocalDate,
        val aktivitet: AktivitetType,
        val periodeType: VedtaksperiodeType
)

data class TilbakekrevingDto(
        val tilbakekrevingsvalg: Tilbakekrevingsvalg,
        val tilbakekrevingMedVarsel: TilbakekrevingMedVarselDto?
)

data class TilbakekrevingMedVarselDto(val varseltekst: String,
                                      val sumFeilutbetaling: BigDecimal? = null, // Hentes fra simulering hvis det mangler
                                      val perioder: List<Periode> = emptyList()) // Hentes fra simulering hvis det mangler

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

enum class VedtaksperiodeType {
    PERIODE_FØR_FØDSEL,
    HOVEDPERIODE,
}

enum class AktivitetType {
    IKKE_AKTIVITETSPLIKT,
    BARN_UNDER_ETT_ÅR,
    FORSØRGER_I_ARBEID,
    FORSØRGER_I_UTDANNING,
    FORSØRGER_REELL_ARBEIDSSØKER,
    FORSØRGER_ETABLERER_VIRKSOMHET,
    BARNET_SÆRLIG_TILSYNSKREVENDE,
    FORSØRGER_MANGLER_TILSYNSORDNING,
    FORSØRGER_ER_SYK,
    BARNET_ER_SYKT,
}

