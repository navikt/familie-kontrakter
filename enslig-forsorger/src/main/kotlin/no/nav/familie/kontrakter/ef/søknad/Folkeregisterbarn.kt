package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Folkeregisterbarn(val navn: Søknadsfelt<String>,
                             val fødselsnummer: Søknadsfelt<Fødselsnummer>,
                             val annenForelder: Søknadsfelt<Forelder>? = null,
                             val samvær: Søknadsfelt<Samvær>? = null,
                             val harSammeAdresse: Søknadsfelt<Boolean>)
