@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Bosituasjon(val delerDuBolig: Felt<String>,
                       val samboerdetaljer: Felt<PersonMinimum>? = null,
                       val sammenflyttingsdato: Felt<LocalDate>? = null)