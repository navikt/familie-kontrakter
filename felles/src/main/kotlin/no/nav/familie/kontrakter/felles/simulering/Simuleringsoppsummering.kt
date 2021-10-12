package no.nav.familie.ef.iverksett.økonomi.simulering

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
                                   val tomSisteUtbetaling: LocalDate?,)


data class Simuleringsperiode(
        val fom: LocalDate,
        val tom: LocalDate,
        val forfallsdato: LocalDate,
        val nyttBeløp: BigDecimal,
        val tidligereUtbetalt: BigDecimal,
        val resultat: BigDecimal,
        val feilutbetaling: BigDecimal,
)
