package no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.kontrakter.ef.felles.StønadType
import java.time.LocalDate
import java.util.*

data class TekniskOpphørDto(
        val forrigeBehandlingId: UUID,
        val tilkjentYtelseMedMetaData: TilkjentYtelseMedMetaData
)

data class TilkjentYtelseMedMetaData(val saksbehandlerId: String,
                                     val eksternBehandlingId: Long,
                                     val stønadstype: StønadType,
                                     val eksternFagsakId: Long,
                                     val personIdent: String,
                                     val behandlingId: UUID,
                                     val vedtaksdato: LocalDate,
                                     val andelerTilkjentYtelse: List<AndelTilkjentYtelseDto>)

