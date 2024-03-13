package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Utenlandsopphold(
    val fradato: Søknadsfelt<LocalDate>,
    val tildato: Søknadsfelt<LocalDate>,
    val land: Søknadsfelt<String>? = null,
    val årsakUtenlandsopphold: Søknadsfelt<String>,
    val personidentEøsLand: Søknadsfelt<String>? = null,
    val adresseEøsLand: Søknadsfelt<String>? = null,
    val erEøsLand: Boolean? = null,
    val kanIkkeOppgiPersonident: Søknadsfelt<Boolean>? = null,
)
