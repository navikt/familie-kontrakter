@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate


@Serializable
data class Arbeidsgiver(val arbeidsgivernavn: Felt<String>,
                        val stillingsprosent: Felt<String>,
                        val fastEllerMidlertidig: Felt<String>,
                        val sluttdato: Felt<LocalDate>? = null)