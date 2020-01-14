package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Selvstendig(val firmanavn: String,
                       val organisasjonsnummer: String,
                       val etableringsdato: LocalDate,
                       val arbeidsmengde: Int,
                       val hvordanSerArbeidsukenUt: Spørsmål<String>,
                       val arbeidsgivere: List<Arbeidsgiver>)