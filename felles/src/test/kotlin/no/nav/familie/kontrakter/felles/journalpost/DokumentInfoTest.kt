package no.nav.familie.kontrakter.felles.journalpost

import no.nav.familie.kontrakter.felles.Brevkoder
import no.nav.familie.kontrakter.felles.Tema
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DokumentInfoTest {

    @Nested
    inner class ErDigitalSøknad {

        @Test
        fun`skal returnere true dersom DokumentInfo har brevkode som passer med tema BAR`() {
            // Arrange
            val dokumentInfo = DokumentInfo(
                dokumentInfoId = "1",
                brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
            )

            // Act & Assert
            assertTrue { dokumentInfo.erDigitalSøknad(Tema.BAR) }
        }

        @Test
        fun`skal returnere false dersom DokumentInfo har brevkode som ikke passer med tema BAR`() {
            // Arrange
            val dokumentInfo = DokumentInfo(
                dokumentInfoId = "1",
                brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
            )

            // Act & Assert
            assertFalse { dokumentInfo.erDigitalSøknad(Tema.BAR) }
        }

        @Test
        fun`skal returnere true dersom DokumentInfo har brevkode som passer med tema KON`() {
            // Arrange
            val dokumentInfo = DokumentInfo(
                dokumentInfoId = "1",
                brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
            )

            // Act & Assert
            assertTrue { dokumentInfo.erDigitalSøknad(Tema.KON) }
        }

        @Test
        fun`skal returnere false dersom DokumentInfo har brevkode som ikke passer med tema KON`() {
            // Arrange
            val dokumentInfo = DokumentInfo(
                dokumentInfoId = "1",
                brevkode = Brevkoder.BARNETRYGD_UTVIDET_SØKNAD,
            )

            // Act & Assert
            assertFalse { dokumentInfo.erDigitalSøknad(Tema.KON) }
        }

        @Test
        fun`skal kaste feil dersom tema ikke er støttet`() {
            // Arrange
            val dokumentInfo = DokumentInfo(
                dokumentInfoId = "1",
                brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
            )

            // Act & Assert
            val error = assertThrows<Error> { dokumentInfo.erDigitalSøknad(Tema.ENF) }
            assertEquals("Støtter ikke tema ENF", error.message)
        }
    }
}
