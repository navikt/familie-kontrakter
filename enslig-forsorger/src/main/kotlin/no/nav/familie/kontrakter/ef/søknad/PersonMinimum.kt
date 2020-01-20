@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class PersonMinimum(val navn: Felt<String>,
                         val fødselsnummer: Felt<Fødselsnummer>? = null,
                         val fødselsdato: Felt<LocalDate>? = null,
                         val adresse: Felt<Adresse>? = null,
                         val land: Felt<String>? = null)
