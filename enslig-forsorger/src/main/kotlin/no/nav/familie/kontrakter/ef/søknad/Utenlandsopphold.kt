@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Utenlandsopphold(val fradato: LocalDate,
                            val tildato: LocalDate,
                            val årsakUtenlandsopphold: Spørsmål<String>)
