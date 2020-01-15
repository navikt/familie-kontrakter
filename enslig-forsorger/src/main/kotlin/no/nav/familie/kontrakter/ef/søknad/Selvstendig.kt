package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Selvstendig(val firmanavn: String,
                       val organisasjonsnummer: String,
                       val etableringsdato: @ContextualSerialization LocalDate,
                       val arbeidsmengde: Int,
                       val hvordanSerArbeidsukenUt: Spørsmål<String>,
                       val arbeidsgivere: List<Arbeidsgiver>?)