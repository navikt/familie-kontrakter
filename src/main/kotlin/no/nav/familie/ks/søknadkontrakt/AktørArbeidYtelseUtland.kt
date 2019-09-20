package no.nav.familie.ks.søknadkontrakt

data class AktørArbeidYtelseUtland(
    val aktørId: String,
    val utlandsTilknytning: OppgittUtlandsTilknytning,
    val arbeidIUtlandet: Standpunkt,
    val arbeidIUtlandetForklaring: String,
    val ytelseIUtlandet: Standpunkt,
    val ytelseIUtlandetForklaring: String,
    val kontantstøtteIUtlandet: Standpunkt,
    val kontantstøtteIUtlandetForklaring: String
)
