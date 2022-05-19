package no.nav.familie.kontrakter.ef.iverksett

import java.time.LocalDate
import java.util.UUID

data class AndelTilkjentYtelseDto(
        val beløp: Int,
        var periodetype: Periodetype,
        val inntekt: Int,
        val inntektsreduksjon: Int,
        val samordningsfradrag: Int,
        val fraOgMed: LocalDate,
        val tilOgMed: LocalDate,
        val kildeBehandlingId: UUID? = null
)

enum class Periodetype {
    MÅNED,
    ENGANGSUTBETALING,
}
