package no.nav.familie.kontrakter.ef.iverksett

import java.util.UUID

class AndelTilkjentYtelseDto(
        val periodebeløp: PeriodebeløpDto,
        val kildeBehandlingId: UUID? = null
)
