package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class PersonMinimumDto(val navn: String,
                            val fødselsnummer: Fødselsnummer?,
                            val fødselsdato: @ContextualSerialization LocalDate?,
                            val adresse: Adresse?,
                            val land: String?)
