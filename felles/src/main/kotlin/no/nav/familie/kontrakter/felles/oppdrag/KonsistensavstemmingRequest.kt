package no.nav.familie.kontrakter.felles.oppdrag

import java.time.LocalDateTime

data class KonsistensavstemmingRequest(val fagsystem: String,
                                       val oppdragIdListe: List<OppdragIdForFagsystem>,
                                       val avstemmingstidspunkt: LocalDateTime)