package main.kotlin.no.nav.familie.ba.søknad

import main.kotlin.no.nav.familie.ba.Søknadstype


data class Søknad(
        val søknadstype: Søknadsfelt<Søknadstype>
)

data class Søknadsfelt<T>(
        val label: String,
        val verdi: T
)
