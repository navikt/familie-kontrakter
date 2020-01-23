package no.nav.familie.kontrakter.ef.søknad

import java.time.Month

data class Stønadsstart(val fraMåned: Søknadsfelt<Month>,
                        val fraÅr: Søknadsfelt<Int>)
