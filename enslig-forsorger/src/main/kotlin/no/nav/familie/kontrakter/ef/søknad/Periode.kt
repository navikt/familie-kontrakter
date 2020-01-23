package no.nav.familie.kontrakter.ef.søknad

import java.time.Month

data class Periode(val fraMåned: Month,
                   val fraÅr: Int,
                   val tilMåned: Month,
                   val tilÅr: Int)
