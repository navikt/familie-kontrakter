package no.nav.familie.ks.kontrakter.søknad

import java.time.LocalDate

data class Barn(
    val barnehageStatus: BarnehageplassStatus,
    val barnehageAntallTimer: Double,
    val barnehageDato: LocalDate,
    val barnehageKommune: String,
    val fødselsnummer: String
)