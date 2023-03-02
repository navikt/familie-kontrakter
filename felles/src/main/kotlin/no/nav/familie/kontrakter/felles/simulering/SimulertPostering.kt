package no.nav.familie.kontrakter.felles.simulering

import java.math.BigDecimal
import java.time.LocalDate

data class SimulertPostering(
    val fagOmrådeKode: FagOmrådeKode,
    val erFeilkonto: Boolean? = null, // brukes for å skille manuelle korigeringer og reelle feilutbetalinger
    val fom: LocalDate,
    val tom: LocalDate,
    val betalingType: BetalingType,
    val beløp: BigDecimal,
    val posteringType: PosteringType,
    val forfallsdato: LocalDate,
    val utenInntrekk: Boolean = false
)
