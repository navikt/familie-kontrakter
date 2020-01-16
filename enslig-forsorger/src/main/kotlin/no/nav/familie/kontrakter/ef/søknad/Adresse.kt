package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Adresse(val gatenavn: String?,
                   val husnummer: Int?,
                   val husbokstav: String?,
                   val bolignummer: String?,
                   val postnummer: String,
                   val poststedsnavn: String?,
                   val kommune: String?)
