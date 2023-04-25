package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Utenlandsopphold(
    val fradato: Søknadsfelt<LocalDate>,
    val tildato: Søknadsfelt<LocalDate>,
    val land: Søknadsfelt<String>,
    val årsakUtenlandsopphold: Søknadsfelt<String>
)
