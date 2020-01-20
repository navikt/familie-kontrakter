package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Felt<T>(val label: String,
                   val verdi: T)
