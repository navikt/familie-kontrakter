package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Datoperiode(
    val fra: LocalDate,
    val til: LocalDate
)
