package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Adresse(val gatenavn: Felt<String>?,
                   val husnummer: Felt<Int>?,
                   val husbokstav: Felt<String>?,
                   val bolignummer: Felt<String>?,
                   val postnummer: Felt<String>,
                   val poststedsnavn: Felt<String>?,
                   val kommune: Felt<String>?)
