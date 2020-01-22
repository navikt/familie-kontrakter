package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable
import java.time.Month

@Serializable
data class Stønadsstart(val fraMåned: Søknadsfelt<Month>,
                        val fraÅr: Søknadsfelt<Int>)
