package no.nav.familie.kontrakter.felles

import java.time.LocalDate
import java.time.YearMonth

data class Periode(
    val fom: LocalDate,
    val tom: LocalDate
) {
    val fomMåned = YearMonth.from(fom)
    val tomMåned = YearMonth.from(tom)

    constructor(
        framåned: YearMonth,
        tilmåned: YearMonth
    ) : this(framåned.atDay(1), tilmåned.atEndOfMonth())
}
