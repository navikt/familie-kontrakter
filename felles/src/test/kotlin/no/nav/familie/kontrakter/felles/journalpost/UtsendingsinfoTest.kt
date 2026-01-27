package no.nav.familie.kontrakter.felles.journalpost

import no.nav.familie.kontrakter.felles.journalpost.Utsendingsmåte.DIGITAL_POST
import no.nav.familie.kontrakter.felles.journalpost.Utsendingsmåte.FYSISK_POST
import no.nav.familie.kontrakter.felles.jsonMapper
import org.junit.jupiter.api.Test
import tools.jackson.module.kotlin.readValue
import kotlin.test.assertEquals
import kotlin.test.assertNull

class UtsendingsinfoTest {
    @Test
    fun `skal mappe utsendingsinfo uten varslingstidspunkt`() {
        val utsendingsinfo = jsonMapper.readValue<Utsendingsinfo>("{\"varselSendt\":[{\"type\":\"SMS\"}]}")
        assertEquals(1, utsendingsinfo.varselSendt.size)
        assertEquals(VarselType.SMS, utsendingsinfo.varselSendt.first().type)
        assertNull(utsendingsinfo.varselSendt.first().varslingstidspunkt)
    }

    @Test
    fun `skal utlede utsendingsmåter fra fysisk og digital post `() {
        assertEquals(emptyList(), Utsendingsinfo(emptyList(), null, null).utsendingsmåter)

        assertEquals(listOf(FYSISK_POST), Utsendingsinfo(emptyList(), FysiskpostSendt("Adresse 1234"), null).utsendingsmåter)

        assertEquals(
            listOf(DIGITAL_POST),
            Utsendingsinfo(emptyList(), null, DigitalpostSendt("digital@adresse.no")).utsendingsmåter,
        )

        assertEquals(
            listOf(FYSISK_POST, DIGITAL_POST),
            Utsendingsinfo(
                emptyList(),
                FysiskpostSendt("Adresse 1234"),
                DigitalpostSendt("digital@adresse.no"),
            ).utsendingsmåter,
        )
    }
}
