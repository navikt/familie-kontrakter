package main.kotlin.no.nav.familie.ba.søknad

import main.kotlin.no.nav.familie.ba.Søknadstype

data class Søker(
        val navn: Søknadsfelt<String>,
        var fødselsnummer: Søknadsfelt<String>? = null
)

data class Søknad(
        val søknadstype: Søknadsfelt<Søknadstype>,
        val søker: Søknadsfelt<Søker>,
        val barn: Søknadsfelt<List<Barn>>
)

data class Søknadsfelt<T>(
        val label: String,
        val verdi: T
)

data class Barn(
        val navn: Søknadsfelt<String>,
        val alder: Søknadsfelt<String>,
        val ident: Søknadsfelt<String>,
        val borMedSøker: Søknadsfelt<String>,
        val medISøknad: Søknadsfelt<Boolean>
)