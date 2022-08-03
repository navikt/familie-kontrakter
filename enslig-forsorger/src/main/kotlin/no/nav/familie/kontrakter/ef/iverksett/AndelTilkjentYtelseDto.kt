package no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.kontrakter.felles.Periode
import java.time.LocalDate
import java.util.UUID

data class AndelTilkjentYtelseDto(
    val beløp: Int,
    val inntekt: Int,
    val inntektsreduksjon: Int,
    val samordningsfradrag: Int,
    @Deprecated("Bruk periode!", ReplaceWith("periode.fomDato")) val fraOgMed: LocalDate? = null,
    @Deprecated("Bruk periode!", ReplaceWith("periode.tomDato")) val tilOgMed: LocalDate? = null,
    val periode: Periode = Periode(
        fraOgMed ?: error("Periode eller fraOgMed må ha verdi!"),
        tilOgMed ?: error("Periode eller traOgMed må ha verdi!")
    ),
    val kildeBehandlingId: UUID? = null
)
