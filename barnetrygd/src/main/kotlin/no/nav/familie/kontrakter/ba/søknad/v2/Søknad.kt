package no.nav.familie.kontrakter.ba.søknad.v2

import no.nav.familie.kontrakter.ba.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.Barn
import no.nav.familie.kontrakter.ba.søknad.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ba.søknad.SøknadAdresse
import no.nav.familie.kontrakter.ba.søknad.Søknaddokumentasjon
import no.nav.familie.kontrakter.ba.søknad.Søknadsfelt

data class Søknad(
    val søknadstype: Søknadstype,
    val søker: Søker,
    val barn: List<Barn>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val dokumentasjon: List<Søknaddokumentasjon>
)

data class Søker(
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val statsborgerskap: Søknadsfelt<List<String>>,
    val adresse: Søknadsfelt<SøknadAdresse>,
    val sivilstand: Søknadsfelt<SIVILSTANDTYPE>,
    val spørsmål: Map<String, Søknadsfelt<Any>>
)
