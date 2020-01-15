package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Utdanning(val linjeKursGrad: String,
                     val fraÅr: Int,
                     val fraMåned: Int,
                     val tilÅr: Int,
                     val tilMåned: Int)