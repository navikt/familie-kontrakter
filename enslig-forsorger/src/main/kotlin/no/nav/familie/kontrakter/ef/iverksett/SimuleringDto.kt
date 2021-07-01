package no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.kontrakter.ef.felles.StønadType
import java.time.LocalDate
import java.util.UUID

data class SimuleringDto(
        val nyTilkjentYtelseMedMetaData: TilkjentYtelseMedMetadata,
        val forrigeBehandlingId: UUID?
)

data class TilkjentYtelseMedMetadata(
        val tilkjentYtelse: SimuleringTilkjentYtelseDto,
        val saksbehandlerId: String,
        val eksternBehandlingId: Long,
        val stønadstype: StønadType,
        val eksternFagsakId: Long,
        val personIdent: String,
        val behandlingId: UUID,
        val vedtaksdato: LocalDate
)

data class SimuleringTilkjentYtelseDto(
        val id: UUID = UUID.randomUUID(),
        val vedtaksdato: LocalDate? = null,
        val andelerTilkjentYtelse: List<AndelTilkjentYtelseDto>
)
