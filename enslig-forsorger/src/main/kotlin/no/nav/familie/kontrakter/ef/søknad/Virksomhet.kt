package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Virksomhet(val virksomhetsbeskrivelse: Søknadsfelt<String>)
