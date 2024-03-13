package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Utenlandsopphold(
    val fradato: Søknadsfelt<LocalDate>,
    val tildato: Søknadsfelt<LocalDate>,
    val land: Søknadsfelt<String>? = null,
    val årsakUtenlandsopphold: Søknadsfelt<String>,
    val personident: Søknadsfelt<String>? = null,
    val adresse: Søknadsfelt<String>? = null,
    val erEøsLand: Søknadsfelt<Boolean>? = null,
    val kanIkkeOppgiPersonident: Søknadsfelt<Boolean>? = null,
)
