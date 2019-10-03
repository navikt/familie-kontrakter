package no.nav.familie.ks.kontrakter.søknad

import java.time.LocalDate

data class Barn(
    val barnehageStatus: BarnehageplassStatus,
    val barnehageAntallTimer: Double?,
    val barnehageDato: LocalDate?,
    val barnehageKommune: String?,
    val barnehageVedlegg: List<String>?,
    val fødselsnummer: String,
    val navn: String?
)