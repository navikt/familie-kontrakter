package no.nav.familie.kontrakter.ef.iverksett

import java.time.LocalDate

data class PeriodebeløpDto(
        val beløp: Int,
        var periodetype: Periodetype,
        val inntekt: Int,
        val inntektsreduksjon: Int,
        val samordningsfradrag: Int,
        val fraOgMed: LocalDate,
        val tilOgMed: LocalDate,
)

enum class Periodetype {
    MÅNED
}