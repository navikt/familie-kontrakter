package no.nav.familie.kontrakter.ef.iverksett

import java.time.LocalDate
import java.time.YearMonth

data class TilkjentYtelseDto(
    val andelerTilkjentYtelse: List<AndelTilkjentYtelseDto>,
    @Deprecated("Bruk startmåned", ReplaceWith("startmåned"))
    val startdato: LocalDate? = null,
    val startmåned: YearMonth = YearMonth.from(startdato ?: error("Startdato eller startmåned må ha verdi"))
)
