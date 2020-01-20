package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Folkeregisterbarn(val navn: Felt<String>,
                             val fødselsnummer: Felt<Fødselsnummer>,
                             val annenForelder: Felt<Forelder>?,
                             val samvær: Felt<Samvær>?,
                             val harSammeAdresse: Felt<Boolean>)
