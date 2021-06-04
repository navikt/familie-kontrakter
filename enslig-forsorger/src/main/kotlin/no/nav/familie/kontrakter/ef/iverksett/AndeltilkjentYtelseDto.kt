package no.nav.familie.kontrakter.ef.iverksett

import java.time.LocalDate
import java.util.UUID

class AndelTilkjentYtelseDto(
        val beløp: Int,
        val fraOgMed: LocalDate,
        val inntekt: Int,
        val inntektsreduksjon: Int,
        val tilOgMed: LocalDate,
        val kildeBehandlingId: UUID? = null
)

