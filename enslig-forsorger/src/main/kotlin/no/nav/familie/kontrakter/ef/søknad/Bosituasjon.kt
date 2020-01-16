@file:ContextualSerialization(LocalDate::class)
package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Bosituasjon(val delerDuBolig: Spørsmål<String>,
                       val samboerdetaljer: PersonMinimum?,
                       val sammenflyttingsdato: Spørsmål<LocalDate>?)