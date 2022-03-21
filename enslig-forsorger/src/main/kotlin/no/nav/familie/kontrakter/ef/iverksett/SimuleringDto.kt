package no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.kontrakter.felles.ef.StønadType
import java.time.LocalDate
import java.util.UUID

data class SimuleringDto(
        val nyTilkjentYtelseMedMetaData: TilkjentYtelseMedMetadata,
        val forrigeBehandlingId: UUID?
)

data class TilkjentYtelseMedMetadata(
        val tilkjentYtelse: TilkjentYtelseDto,
        val saksbehandlerId: String,
        val eksternBehandlingId: Long,
        val stønadstype: StønadType,
        val eksternFagsakId: Long,
        val personIdent: String,
        val behandlingId: UUID,
        val vedtaksdato: LocalDate
)

