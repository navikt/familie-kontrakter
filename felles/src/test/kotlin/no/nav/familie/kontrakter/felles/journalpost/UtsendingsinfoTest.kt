package no.nav.familie.kontrakter.felles.journalpost

import no.nav.familie.kontrakter.felles.journalpost.Utsendingsmåte.DIGITAL_POST
import no.nav.familie.kontrakter.felles.journalpost.Utsendingsmåte.FYSISK_POST
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class UtsendingsinfoTest {

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
