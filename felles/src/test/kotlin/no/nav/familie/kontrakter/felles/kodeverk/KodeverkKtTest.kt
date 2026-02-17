package no.nav.familie.kontrakter.felles.kodeverk

import no.nav.familie.kontrakter.felles.jsonMapper
import org.junit.jupiter.api.Test
import tools.jackson.module.kotlin.readValue
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertNull

internal class KodeverkKtTest {
    val kodeverk =
        jsonMapper.readValue<KodeverkDto>(
            """
            {"betydninger": {
              "5036": [
               {"gyldigFra": "2003-10-01",
                "gyldigTil": "2010-12-31",
                "beskrivelser": {
                 "nb": {
                  "term": "BERGEN",
                  "tekst": "BERGEN"
                 }}},
               {"gyldigFra": "2011-10-01",
                "gyldigTil": "9999-12-31",
                "beskrivelser": {
                 "nb": {
                  "term": "BERGEN2",
                  "tekst": "BERGEN2"
                 }}}]}}
            """.trimIndent(),
        )

    @Test
    internal fun `skal hente kodeverk som er gyldig for gitt dato`() {
        assertEquals("BERGEN", kodeverk.hentGjeldende("5036", LocalDate.of(2009, 1, 1)))
        assertEquals("BERGEN2", kodeverk.hentGjeldende("5036", LocalDate.of(2021, 1, 1)))
    }

    @Test
    fun `skal returnere null hvis den ikke finner kodeverdi for gitt dato`() {
        assertNull(kodeverk.hentGjeldende("5036", LocalDate.of(1900, 1, 1)))
    }

    @Test
    internal fun `skal hente siste gjeldende kodeverk hvis verdi mangler, med sisteGjeldende=true`() {
        assertEquals(
            "BERGEN2",
            kodeverk.hentGjeldende("5036", LocalDate.of(1900, 1, 1), sisteGjeldende = true),
        )
        assertNull(kodeverk.hentGjeldende("FINNES_IKKE", LocalDate.of(1900, 1, 1), sisteGjeldende = true))
    }
}
