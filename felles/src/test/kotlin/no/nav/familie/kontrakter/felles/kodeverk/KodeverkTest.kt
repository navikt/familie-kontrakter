package no.nav.familie.kontrakter.felles.kodeverk

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

internal class KodeverkTest {
    @Test
    internal fun `finner gjeldende term når det kun finnes en betydning`() {
        val kodeverk =
            KodeverkDto(
                betydninger =
                    mapOf(
                        "NOR" to
                            listOf(
                                BetydningDto(
                                    gyldigFra = LocalDate.of(2020, 1, 15),
                                    gyldigTil = LocalDate.of(2020, 1, 16),
                                    beskrivelser = mapOf("nb" to BeskrivelseDto("Norge", "NorgeTekst")),
                                ),
                            ),
                    ),
            )
        assertEquals("Norge", kodeverk.hentGjeldende("NOR", LocalDate.of(2020, 1, 16)))
        assertNull(kodeverk.hentGjeldende("NOR"))
    }

    @Test
    internal fun `finner gjelde term når det finnes flere betyninger`() {
        val kodeverk =
            KodeverkDto(
                betydninger =
                    mapOf(
                        "NOR" to
                            listOf(
                                BetydningDto(
                                    gyldigFra = LocalDate.of(2020, 1, 15),
                                    gyldigTil = LocalDate.of(2020, 1, 16),
                                    beskrivelser = mapOf("nb" to BeskrivelseDto("Sverige", "SverigeTekst")),
                                ),
                                BetydningDto(
                                    gyldigFra = LocalDate.of(2020, 1, 17),
                                    gyldigTil = LocalDate.of(2099, 1, 16),
                                    beskrivelser = mapOf("nb" to BeskrivelseDto("Norge", "NorgeTekst")),
                                ),
                            ),
                    ),
            )
        assertEquals("Sverige", kodeverk.hentGjeldende("NOR", LocalDate.of(2020, 1, 16)))
        assertEquals("Norge", kodeverk.hentGjeldende("NOR"))
    }

    @Test
    internal fun `finner ingen gjeldende term når det ikke finnes en betydning`() {
        assertNull(KodeverkDto(betydninger = mapOf("NOR" to emptyList())).hentGjeldende("NOR"))
    }
}
