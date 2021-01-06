package no.nav.familie.oppdrag.simulering.repository

import java.math.BigDecimal
import java.time.LocalDate

data class SimulertPostering(val fagOmrådeKode: FagOmrådeKode,
                             val fom: LocalDate,
                             val tom: LocalDate,
                             val betalingType: BetalingType,
                             val beløp: BigDecimal,
                             val posteringType: PosteringType,
                             val forfallsdato: LocalDate,
                             val utenInntrekk: Boolean = false)
