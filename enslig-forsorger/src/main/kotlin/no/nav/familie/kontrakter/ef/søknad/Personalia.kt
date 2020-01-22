package no.nav.familie.kontrakter.ef.søknad

data class Personalia(val fødselsnummer: Søknadsfelt<Fødselsnummer>,
                      val navn: Søknadsfelt<String>,
                      val statsborgerskap: Søknadsfelt<String>,
                      val adresse: Søknadsfelt<Adresse>,
                      val telefonnummer: Søknadsfelt<String>? = null,
                      val sivilstatus: Søknadsfelt<String>)

