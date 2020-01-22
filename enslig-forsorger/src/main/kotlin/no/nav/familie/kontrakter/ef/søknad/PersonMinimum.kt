@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class PersonMinimum(val navn: Søknadsfelt<String>,
                         val fødselsnummer: Søknadsfelt<Fødselsnummer>? = null,
                         val fødselsdato: Søknadsfelt<LocalDate>? = null,
                         val adresse: Søknadsfelt<Adresse>? = null,
                         val land: Søknadsfelt<String>? = null)
