package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Utenlandsopphold(val fradato: @ContextualSerialization LocalDate,
                            val tildato: @ContextualSerialization LocalDate)
