package no.nav.familie.kontrakter.ef.søknad

data class Spørsmål<T>(val spørsmål: String,
                       val svar: T)
