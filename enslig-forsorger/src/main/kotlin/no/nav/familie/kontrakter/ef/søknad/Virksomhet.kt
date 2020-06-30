package no.nav.familie.kontrakter.ef.søknad

data class Virksomhet(val virksomhetsbeskrivelse: Søknadsfelt<String>,
                      val dokumentasjon: Søknadsfelt<Dokumentasjon>? = null)
