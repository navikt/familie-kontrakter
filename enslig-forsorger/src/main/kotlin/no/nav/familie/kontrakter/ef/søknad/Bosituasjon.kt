@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Bosituasjon(val delerDuBolig: Søknadsfelt<String>,
                       val samboerdetaljer: Søknadsfelt<PersonMinimum>? = null,
                       val sammenflyttingsdato: Søknadsfelt<LocalDate>? = null)
