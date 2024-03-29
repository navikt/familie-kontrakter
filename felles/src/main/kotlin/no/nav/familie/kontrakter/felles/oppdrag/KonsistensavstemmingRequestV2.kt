package no.nav.familie.kontrakter.felles.oppdrag

import java.time.LocalDateTime

data class KonsistensavstemmingRequestV2(
    val fagsystem: String,
    val perioderForBehandlinger: List<PerioderForBehandling>,
    val avstemmingstidspunkt: LocalDateTime,
)
