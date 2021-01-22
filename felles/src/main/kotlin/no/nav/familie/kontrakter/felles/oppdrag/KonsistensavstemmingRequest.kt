package no.nav.familie.kontrakter.felles.oppdrag

import java.time.LocalDateTime

@Deprecated(message = "Trenger å sende med periodeIdn",
            replaceWith = ReplaceWith("no.nav.familie.kontrakter.felles.oppdrag.KonsistensavstemmingRequestV2"))
data class KonsistensavstemmingRequest(val fagsystem: String,
                                       val oppdragIdListe: List<OppdragIdForFagsystem>,
                                       val avstemmingstidspunkt: LocalDateTime)