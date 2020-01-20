@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Selvstendig(val firmanavn: Felt<String>,
                       val organisasjonsnummer: Felt<String>,
                       val etableringsdato: Felt<LocalDate>,
                       val arbeidsmengde: Felt<Int>,
                       val hvordanSerArbeidsukenUt: Felt<String>,
                       val arbeidsgivere: Felt<List<Arbeidsgiver>>?)