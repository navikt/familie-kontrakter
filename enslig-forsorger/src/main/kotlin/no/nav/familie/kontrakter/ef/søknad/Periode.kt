package no.nav.familie.kontrakter.ef.søknad

import java.time.Month

data class Periode(val fraÅr: Søknadsfelt<Int>,
                   val fraMåned: Søknadsfelt<Month>,
                   val tilÅr: Søknadsfelt<Int>,
                   val tilMåned: Søknadsfelt<Month>)
