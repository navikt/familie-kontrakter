package no.nav.familie.kontrakter.ef.søknad

data class Folkeregisterbarn(val navn: Søknadsfelt<String>,
                             val fødselsnummer: Søknadsfelt<Fødselsnummer>,
                             val harSammeAdresse: Søknadsfelt<Boolean>,
                             val annenForelder: Søknadsfelt<Forelder>? = null,
                             val samvær: Søknadsfelt<Samvær>? = null)
