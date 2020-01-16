@file:ContextualSerialization(LocalDate::class)
package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Sivilstandsplaner(val harPlaner: Spørsmål<Boolean>,
                             val fraDato: Spørsmål<LocalDate>?,
                             val vordendeSamboerEktefelle: PersonMinimum?)
