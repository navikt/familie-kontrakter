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
    val periode: Periode? = null,
    val kildeBehandlingId: UUID? = null
) {

    init {
        require(periode != null || (fraOgMed != null && tilOgMed != null)) { "Periode mangler verdi!" }
    }

    fun periode(): Periode = periode ?: Periode(this.fraOgMed!!, this.tilOgMed!!)
}
