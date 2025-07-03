package no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.kontrakter.felles.Månedsperiode
import java.time.LocalDate
import java.time.YearMonth
import java.util.UUID

data class AndelTilkjentYtelseDto(
    val beløp: Int,
    val inntekt: Int,
    val inntektsreduksjon: Int,
    val samordningsfradrag: Int,
    @Deprecated("Bruk periode!", ReplaceWith("periode.fom")) val fraOgMed: LocalDate? = null,
    @Deprecated("Bruk periode!", ReplaceWith("periode.tom")) val tilOgMed: LocalDate? = null,
    val periode: Månedsperiode =
        Månedsperiode(
            YearMonth.from(fraOgMed) ?: error("Periode eller fraOgMed må ha verdi!"),
            YearMonth.from(tilOgMed) ?: error("Periode eller fraOgMed må ha verdi!"),
        ),
    val kildeBehandlingId: UUID? = null,
)
