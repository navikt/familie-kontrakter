package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate
import java.time.LocalDateTime

data class Innsendingsdetaljer(val datoMottatt: Søknadsfelt<LocalDateTime>, val datoPåbegyntSøknad: LocalDate? = null)
