package no.nav.familie.kontrakter.ef.søknad

import no.nav.familie.kontrakter.felles.Fødselsnummer

data class Personalia(
    val fødselsnummer: Søknadsfelt<Fødselsnummer>,
    val navn: Søknadsfelt<String>,
    val statsborgerskap: Søknadsfelt<String>,
    val adresse: Søknadsfelt<Adresse>,
    val sivilstatus: Søknadsfelt<String>,
)
