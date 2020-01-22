package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Adresse(val gatenavn: Søknadsfelt<String>? = null,
                   val husnummer: Søknadsfelt<Int>? = null,
                   val husbokstav: Søknadsfelt<String>? = null,
                   val bolignummer: Søknadsfelt<String>? = null,
                   val postnummer: Søknadsfelt<String>,
                   val poststedsnavn: Søknadsfelt<String>? = null,
                   val kommune: Søknadsfelt<String>? = null)
