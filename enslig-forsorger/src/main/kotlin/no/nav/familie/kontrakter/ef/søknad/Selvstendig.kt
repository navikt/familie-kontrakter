@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Selvstendig(val firmanavn: Søknadsfelt<String>,
                       val organisasjonsnummer: Søknadsfelt<String>,
                       val etableringsdato: Søknadsfelt<LocalDate>,
                       val arbeidsmengde: Søknadsfelt<Int>,
                       val hvordanSerArbeidsukenUt: Søknadsfelt<String>,
                       val arbeidsgivere: Søknadsfelt<List<Arbeidsgiver>>? = null)
