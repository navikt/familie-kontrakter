package no.nav.familie.kontrakter.ef.søknad

data class Adresse(val gatenavn: String? = null,
                   val husnummer: Int? = null,
                   val husbokstav: String? = null,
                   val bolignummer: String? = null,
                   val postnummer: String,
                   val poststedsnavn: String? = null,
                   val land: String? = null)
