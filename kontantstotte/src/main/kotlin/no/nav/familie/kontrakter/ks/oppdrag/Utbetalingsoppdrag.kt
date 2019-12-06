package no.nav.familie.ks.kontrakter.oppdrag

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class Utbetalingsoppdrag (
    val kodeEndring: KodeEndring,
    val fagSystem: String,
    val saksnummer: String,
    val aktoer: String,
    val saksbehandlerId: String,
    val avstemmingTidspunkt: LocalDateTime = LocalDateTime.now(),
    val utbetalingsperiode: List<Utbetalingsperiode>
) {
    enum class KodeEndring { NY, ENDR, UENDR }
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class Utbetalingsperiode (
    val erEndringPåEksisterendePeriode: Boolean,
    val opphør: Opphør?,
    val datoForVedtak: LocalDate,
    val klassifisering: String,
    val vedtakdatoFom: LocalDate,
    val vedtakdatoTom: LocalDate,
    val sats: BigDecimal,
    val satsType: SatsType,
    val utbetalesTil: String,
    val behandlingId: Long
)  {
    enum class SatsType { DAG, MND, ENG }
}

data class Opphør (
    val opphørDatoFom: LocalDate
)
