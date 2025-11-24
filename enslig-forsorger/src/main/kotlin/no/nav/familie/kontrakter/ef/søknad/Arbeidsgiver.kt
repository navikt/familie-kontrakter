package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

/**
 * Arbeidsmengde skal ikke fylles ut av Barnetilsyn
 */

data class Arbeidsgiver(
    val arbeidsgivernavn: Søknadsfelt<String>,
    val arbeidsmengde: Søknadsfelt<Int>? = null,
    val fastEllerMidlertidig: Søknadsfelt<String>,
    val harSluttdato: Søknadsfelt<Boolean>?,
    val sluttdato: Søknadsfelt<LocalDate>? = null,
)
