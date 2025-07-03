package no.nav.familie.kontrakter.felles.ef

import java.time.LocalDate

/**
 * Klasser som brukes for å hente perioder fra enslig forsørger (ef-sak)
 */

data class EksternePerioderRequest(
    val personIdent: String,
    val fomDato: LocalDate? = null,
    val tomDato: LocalDate? = null,
)

data class EksternePerioderResponse(
    val perioder: List<EksternPeriode>,
)

data class EksternePerioderMedBeløpResponse(
    val perioder: List<EksternPeriodeMedBeløp>,
)

data class EksternPeriode(
    val personIdent: String,
    val fomDato: LocalDate,
    val tomDato: LocalDate,
    val datakilde: Datakilde,
)

data class EksternPeriodeMedBeløp(
    val personIdent: String,
    val fomDato: LocalDate,
    val tomDato: LocalDate,
    val beløp: Int,
    val datakilde: Datakilde,
)

enum class Datakilde {
    INFOTRYGD,
    EF,
}

data class EksternePerioderForStønadstyperRequest(
    val personIdent: String,
    val fomDato: LocalDate? = null,
    val tomDato: LocalDate? = null,
    val stønadstyper: List<StønadType> = listOf(),
)

data class EksternePerioderMedStønadstypeResponse(
    val personIdent: String,
    val perioder: List<EksternPeriodeMedStønadstype>,
)

data class EksternPeriodeMedStønadstype(
    val fomDato: LocalDate,
    val tomDato: LocalDate,
    val stønadstype: StønadType,
)
