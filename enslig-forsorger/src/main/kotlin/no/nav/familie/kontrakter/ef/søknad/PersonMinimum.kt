package no.nav.familie.kontrakter.ef.søknad

import no.nav.familie.Fødselsnummer
import java.time.LocalDate

data class PersonMinimum(
    val navn: Søknadsfelt<String>,
    val fødselsnummer: Søknadsfelt<Fødselsnummer>? = null,
    val fødselsdato: Søknadsfelt<LocalDate>? = null,
    val land: Søknadsfelt<String>? = null
)
