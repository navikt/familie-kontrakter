package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Personalia(val fødselsnummer: Felt<Fødselsnummer>,
                      val navn: Felt<String>,
                      val statsborgerskap: Felt<String>,
                      val adresse: Felt<Adresse>,
                      val telefonnummer: Felt<String>?,
                      val sivilstatus: Felt<String>)

