package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Folkeregisterbarn(val navn: String,
                             val fødselsnummer: Fødselsnummer,
                             val annenForelder: ForelderDto?,
                             val samvær: Samvær?,
                             val harSammeAdresse: Boolean)
