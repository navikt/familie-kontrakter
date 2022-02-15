package no.nav.familie.kontrakter.ef.iverksett

import java.time.LocalDate

data class TilkjentYtelseDto(
        val andelerTilkjentYtelse: List<AndelTilkjentYtelseDto>,
        val opphørsdato: LocalDate? = null
)



