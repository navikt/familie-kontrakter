package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Spørsmål<T>(val spørsmål: String,
                       val svar: T)
