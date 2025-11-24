package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

/**
 * Arbeidsmengde skal ikke fylles ut av Barnetilsyn
 */

data class Selvstendig(
    val firmanavn: Søknadsfelt<String>,
    val organisasjonsnummer: Søknadsfelt<String>,
    val etableringsdato: Søknadsfelt<LocalDate>,
    val arbeidsmengde: Søknadsfelt<Int>? = null,
    val hvordanSerArbeidsukenUt: Søknadsfelt<String>,
    val overskudd: Søknadsfelt<Int>? = null,
)
