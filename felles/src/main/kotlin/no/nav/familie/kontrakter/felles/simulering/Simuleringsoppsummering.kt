package no.nav.familie.kontrakter.felles.simulering

import no.nav.familie.kontrakter.felles.Periode
import java.math.BigDecimal
import java.time.LocalDate

data class Simuleringsoppsummering(val perioder: List<Simuleringsperiode>,
                                   val fomDatoNestePeriode: LocalDate?,
                                   val etterbetaling: BigDecimal,
                                   val feilutbetaling: BigDecimal,
                                   val fom: LocalDate?,
                                   val tomDatoNestePeriode: LocalDate?,
                                   val forfallsdatoNestePeriode: LocalDate?,
                                   val tidSimuleringHentet: LocalDate?,
                                   val tomSisteUtbetaling: LocalDate?,
                                   val feilutbetalingsperioder: List<Periode> = emptyList())


data class Simuleringsperiode(
        val fom: LocalDate,
        val tom: LocalDate,
        val forfallsdato: LocalDate,
        val nyttBeløp: BigDecimal,
        val tidligereUtbetalt: BigDecimal,
        val resultat: BigDecimal,
        val feilutbetaling: BigDecimal
) {
    constructor(
            periode: Periode,
            forfallsdato: LocalDate,
            nyttBeløp: BigDecimal,
            tidligereUtbetalt: BigDecimal,
            resultat: BigDecimal,
            feilutbetaling: BigDecimal
    ) : this(
          periode.fom,
          periode.tom,
          forfallsdato,
          nyttBeløp,
          tidligereUtbetalt,
          resultat,
          feilutbetaling
    )

    val periode: Periode
        get() = Periode(fom,tom)
}
