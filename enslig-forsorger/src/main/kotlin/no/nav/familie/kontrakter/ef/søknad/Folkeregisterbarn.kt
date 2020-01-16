package no.nav.familie.kontrakter.ef.søknad


data class Folkeregisterbarn(val navn: String,
                             val fødselsnummer: Fødselsnummer,
                             val annenForelder: Forelder?,
                             val samvær: Samvær?,
                             val harSammeAdresse: Boolean)
