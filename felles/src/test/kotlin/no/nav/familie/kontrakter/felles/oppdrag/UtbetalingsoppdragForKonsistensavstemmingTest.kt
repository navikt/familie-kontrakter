package no.nav.familie.kontrakter.felles.oppdrag

import no.nav.familie.kontrakter.felles.jsonMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

class UtbetalingsoppdragForKonsistensavstemmingTest {
    @Test
    fun `skal deserialisere JSON med samme form som familie-oppdrag-backend returnerer`() {
        val forventet =
            UtbetalingsoppdragForKonsistensavstemming(
                fagsakId = "200",
                behandlingId = "100",
                utbetalingsoppdrag =
                    Utbetalingsoppdrag(
                        kodeEndring = Utbetalingsoppdrag.KodeEndring.NY,
                        fagSystem = "BA",
                        saksnummer = "200",
                        aktoer = "12345678910",
                        saksbehandlerId = "Z999999",
                        avstemmingTidspunkt = LocalDateTime.of(2026, 1, 1, 12, 0),
                        utbetalingsperiode =
                            listOf(
                                Utbetalingsperiode(
                                    erEndringPåEksisterendePeriode = false,
                                    periodeId = 0,
                                    datoForVedtak = LocalDate.of(2026, 1, 1),
                                    klassifisering = "BATR",
                                    vedtakdatoFom = LocalDate.of(2026, 1, 1),
                                    vedtakdatoTom = LocalDate.of(2026, 12, 31),
                                    sats = BigDecimal("1968"),
                                    satsType = Utbetalingsperiode.SatsType.MND,
                                    utbetalesTil = "12345678910",
                                    behandlingId = 100,
                                ),
                            ),
                    ),
            )

        val json = jsonMapper.writeValueAsString(forventet)
        val tre = jsonMapper.readTree(json)

        assertEquals(setOf("fagsakId", "behandlingId", "utbetalingsoppdrag"), tre.propertyNames().asSequence().toSet())
        assertEquals(forventet, jsonMapper.readValue(json, UtbetalingsoppdragForKonsistensavstemming::class.java))
    }
}
