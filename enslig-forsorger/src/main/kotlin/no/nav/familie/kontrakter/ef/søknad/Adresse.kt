package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Adresse(val gatenavn: Felt<String>? = null,
                   val husnummer: Felt<Int>? = null,
                   val husbokstav: Felt<String>? = null,
                   val bolignummer: Felt<String>? = null,
                   val postnummer: Felt<String>,
                   val poststedsnavn: Felt<String>? = null,
                   val kommune: Felt<String>? = null)
