package no.nav.familie.ks.søknadkontrakt

data class ArbeidYtelseUtland(
    val arbeiderIUtlandet: Standpunkt,
    val arbeiderIUtlandetForklaring: String,
    val arbeiderAnnenForelderIUtlandet: Standpunkt,
    val arbeiderAnnenForelderIUtlandetForklaring: String,
    val mottarAnnenForelderYtelserFraUtland: Standpunkt,
    val mottarAnnenForelderYtelserFraUtlandForklaring: String,
    val mottarYtelserFraUtland: Standpunkt,
    val mottarYtelserFraUtlandForklaring: String,
    val mottarKontantstotteFraUtlandet: Standpunkt,
    val mottarKontantstotteFraUtlandetForklaring: String
)
