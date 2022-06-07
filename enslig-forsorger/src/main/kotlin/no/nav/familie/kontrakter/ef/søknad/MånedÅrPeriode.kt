package no.nav.familie.kontrakter.ef.søknad

import java.time.Month

data class MånedÅrPeriode(
    val fraMåned: Month,
    val fraÅr: Int,
    val tilMåned: Month,
    val tilÅr: Int
)
