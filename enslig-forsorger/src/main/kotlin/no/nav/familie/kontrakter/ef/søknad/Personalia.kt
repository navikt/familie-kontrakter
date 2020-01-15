package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Personalia(val fødselsnummer: Fødselsnummer,
                      val navn: String,
                      val statsborgerskap: String,
                      val adresse: Adresse,
                      val telefonnummer: String?,
                      val sivilstatus: String)

