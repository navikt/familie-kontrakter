package no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.Månedsperiode
import java.time.LocalDate
import java.time.YearMonth
import java.util.UUID

data class AndelTilkjentYtelseDto(
    val beløp: Int,
    val inntekt: Int,
    val inntektsreduksjon: Int,
    val samordningsfradrag: Int,
    @Deprecated("Bruk periode!", ReplaceWith("periode.fomDato")) val fraOgMed: LocalDate,
    @Deprecated("Bruk periode!", ReplaceWith("periode.tomDato")) val tilOgMed: LocalDate,
    val periode: Månedsperiode = Månedsperiode(
        YearMonth.from(fraOgMed),
        YearMonth.from(tilOgMed)
    ),
    val kildeBehandlingId: UUID? = null
)
