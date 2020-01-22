@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate


@Serializable
data class Arbeidsgiver(val arbeidsgivernavn: Søknadsfelt<String>,
                        val stillingsprosent: Søknadsfelt<String>,
                        val fastEllerMidlertidig: Søknadsfelt<String>,
                        val sluttdato: Søknadsfelt<LocalDate>? = null)
