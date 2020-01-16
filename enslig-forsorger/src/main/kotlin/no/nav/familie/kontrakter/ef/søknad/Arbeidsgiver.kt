@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate


@Serializable
data class Arbeidsgiver(val arbeidsgivernavn: String,
                        val stillingsprosent: String,
                        val fastEllerMidlertidig: Spørsmål<String>,
                        val sluttdato: LocalDate?)