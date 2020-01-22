package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Utdanning(val linjeKursGrad: Søknadsfelt<String>,
                     val fraÅr: Søknadsfelt<Int>,
                     val fraMåned: Søknadsfelt<Int>,
                     val tilÅr: Søknadsfelt<Int>,
                     val tilMåned: Søknadsfelt<Int>)
