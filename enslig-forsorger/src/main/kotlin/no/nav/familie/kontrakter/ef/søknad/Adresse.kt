package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Adresse(val gatenavn: String? = null,
                   val husnummer: Int? = null,
                   val husbokstav: String? = null,
                   val bolignummer: String? = null,
                   val postnummer: String,
                   val poststedsnavn: String? = null,
                   val kommune: String? = null)
