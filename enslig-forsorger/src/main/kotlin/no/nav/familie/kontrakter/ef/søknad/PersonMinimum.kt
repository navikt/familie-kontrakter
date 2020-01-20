@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class PersonMinimum(val navn: Felt<String>,
                         val fødselsnummer: Felt<Fødselsnummer>?,
                         val fødselsdato: Felt<LocalDate>?,
                         val adresse: Felt<Adresse>?,
                         val land: Felt<String>?)
