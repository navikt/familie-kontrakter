package no.nav.familie.kontrakter.felles.simulering

import java.math.BigDecimal
import java.time.LocalDate

data class HentFeilutbetalingerFraSimuleringRequest(val fagOmrådeKode: FagOmrådeKode,
                                                    val eksternFagsakId: String,
                                                    val behandlingId: String)

data class FeilutbetalingerFraSimulering(val feilutbetaltePerioder: List<FeilutbetaltPeriode>)

data class FeilutbetaltPeriode(val fom: LocalDate,
                               val tom: LocalDate,
                               val nyttBeløp: BigDecimal,
                               val tidligereUtbetaltBeløp: BigDecimal,
                               val feilutbetaltBeløp: BigDecimal)
