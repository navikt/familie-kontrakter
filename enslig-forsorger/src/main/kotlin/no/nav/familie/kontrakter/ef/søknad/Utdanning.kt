package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Utdanning(val linjeKursGrad: Felt<String>,
                     val fraÅr: Felt<Int>,
                     val fraMåned: Felt<Int>,
                     val tilÅr: Felt<Int>,
                     val tilMåned: Felt<Int>)