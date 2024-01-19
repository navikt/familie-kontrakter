package no.nav.familie.kontrakter.felles.oppdrag

import java.time.LocalDateTime
import java.util.UUID

/**
 * @property avstemmingId Unik id for en grenseavsnittsavstemming.
 * Dersom det er fulllført en grenseavsnittsavstemming på en avstemmingId vil alle fremdtidige grenseavsnittsavstemminger på samme avstemmingId ignoreres.
 */
data class GrensesnittavstemmingRequest(
    val fagsystem: String,
    val fra: LocalDateTime,
    val til: LocalDateTime,
    val avstemmingId: UUID?,
)
