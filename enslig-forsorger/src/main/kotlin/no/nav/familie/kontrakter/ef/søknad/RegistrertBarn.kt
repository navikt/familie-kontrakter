package no.nav.familie.kontrakter.ef.søknad

data class RegistrertBarn(val navn: Søknadsfelt<String>,
                          val fødselsnummer: Søknadsfelt<Fødselsnummer>,
                          val harSammeAdresse: Søknadsfelt<Boolean>,
                          val ikkeRegistrertPåSøkersAdresseBeskrivelse: Søknadsfelt<String>,
                          val annenForelder: Søknadsfelt<AnnenForelder>? = null,
                          val samvær: Søknadsfelt<Samvær>? = null)