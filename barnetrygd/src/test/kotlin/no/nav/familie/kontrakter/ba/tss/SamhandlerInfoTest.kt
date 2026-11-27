@file:Suppress("DEPRECATION")

package no.nav.familie.kontrakter.ba.tss

import no.nav.familie.kontrakter.felles.jsonMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class SamhandlerInfoTest {
    @Test
    fun `gamle typenavn i barnetrygd skal fortsatt kunne brukes etter flytting til felles`() {
        val samhandler: SamhandlerInfo =
            SamhandlerInfo(
                tssEksternId = "80000000001",
                navn = "Begravelsesbyrå AS",
                adresser =
                    listOf(
                        SamhandlerAdresse(
                            adresselinjer = listOf("Gate 1"),
                            postNr = "0001",
                            postSted = "Oslo",
                            adresseType = "ARBEIDSADRESSE",
                            gyldighetsperiode = Gyldighetsperiode(fom = LocalDate.of(2020, 1, 1), tom = null),
                        ),
                    ),
                orgNummer = "123456789",
            )

        val json = jsonMapper.writeValueAsString(SøkSamhandlerInfo(finnesMerInfo = false, samhandlere = listOf(samhandler)))

        assertEquals(
            samhandler,
            jsonMapper.readValue(json, no.nav.familie.kontrakter.felles.tss.SøkSamhandlerInfo::class.java).samhandlere.single(),
        )
    }
}
