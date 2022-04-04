package no.nav.familie.kontrakter.felles.simulering

import no.nav.familie.kontrakter.felles.Fagsystem
import java.math.BigDecimal
import java.time.LocalDate

data class HentFeilutbetalingerFraSimuleringRequest(private val fagsystem: Fagsystem,
                                                    private val eksternFagsakId: String,
                                                    private val behandlingId: String)

data class FeilutbetalingerFraSimulering(private val feilutbetaltePerioder: List<FeilutbetaltPeriode>)

data class FeilutbetaltPeriode(private val fom: LocalDate,
                               private val tom: LocalDate,
                               private val nyttBeløp: BigDecimal,
                               private val tidligereUtbetaltBeløp: BigDecimal,
                               private val feilutbetaltBeløp: BigDecimal)
