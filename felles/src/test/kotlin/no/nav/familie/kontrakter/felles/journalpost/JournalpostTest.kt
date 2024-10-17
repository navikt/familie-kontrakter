package no.nav.familie.kontrakter.felles.journalpost

import no.nav.familie.kontrakter.felles.Brevkoder
import no.nav.familie.kontrakter.felles.Tema
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class JournalpostTest {

    @Test
    fun `skal returnere true dersom journalpost er digital kontantstøtte søknad og tema er KON`() {
        // Arrange
        val journalpost = Journalpost(
            journalpostId = "123",
            journalposttype = Journalposttype.I,
            journalstatus = Journalstatus.MOTTATT,
            kanal = "NAV_NO",
            dokumenter = listOf(
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                ),
            ),
        )

        // Act
        val erDigitalSøknad = journalpost.harDigitalSøknad(Tema.KON)

        // Assert
        assertTrue(erDigitalSøknad)
    }

    @Test
    fun `skal returnere false dersom journalpost ikke er digital kontantstøtte søknad og tema er KON`() {
        // Arrange
        val journalpost = Journalpost(
            journalpostId = "123",
            journalposttype = Journalposttype.I,
            journalstatus = Journalstatus.MOTTATT,
            kanal = "NAV_NO",
            dokumenter = listOf(
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                ),
            ),
        )

        // Act
        val erDigitalSøknad = journalpost.harDigitalSøknad(Tema.KON)

        // Assert
        assertFalse(erDigitalSøknad)
    }

    @Test
    fun `skal returnere false dersom journalpost ikke inneholder noen dokumenter og tema er KON`() {
        // Arrange
        val journalpost = Journalpost(
            journalpostId = "123",
            journalposttype = Journalposttype.I,
            journalstatus = Journalstatus.MOTTATT,
            kanal = "NAV_NO",
            dokumenter = null,
        )

        // Act
        val erDigitalSøknad = journalpost.harDigitalSøknad(Tema.KON)

        // Assert
        assertFalse(erDigitalSøknad)
    }

    @Test
    fun `skal returnere false dersom journalpost ikke har kommet via digital kanal og tema er KON`() {
        // Arrange
        val journalpost = Journalpost(
            journalpostId = "123",
            journalposttype = Journalposttype.I,
            journalstatus = Journalstatus.MOTTATT,
            kanal = "SKAN_",
            dokumenter = emptyList(),
        )

        // Act
        val erDigitalSøknad = journalpost.harDigitalSøknad(Tema.KON)

        // Assert
        assertFalse(erDigitalSøknad)
    }

    @Test
    fun `skal returnere true dersom journalpost er digital barnetrygd søknad og tema er BAR`() {
        // Arrange
        val journalpost = Journalpost(
            journalpostId = "123",
            journalposttype = Journalposttype.I,
            journalstatus = Journalstatus.MOTTATT,
            kanal = "NAV_NO",
            dokumenter = listOf(
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                ),
            ),
        )

        // Act
        val erDigitalSøknad = journalpost.harDigitalSøknad(Tema.BAR)

        // Assert
        assertTrue(erDigitalSøknad)
    }

    @Test
    fun `skal returnere false dersom journalpost ikke er digital barnetrygd søknad og tema er BAR`() {
        // Arrange
        val journalpost = Journalpost(
            journalpostId = "123",
            journalposttype = Journalposttype.I,
            journalstatus = Journalstatus.MOTTATT,
            kanal = "NAV_NO",
            dokumenter = listOf(
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                ),
            ),
        )

        // Act
        val erDigitalSøknad = journalpost.harDigitalSøknad(Tema.BAR)

        // Assert
        assertFalse(erDigitalSøknad)
    }

    @Test
    fun `skal returnere false dersom journalpost ikke inneholder noen dokumenter og tema er BAR`() {
        // Arrange
        val journalpost = Journalpost(
            journalpostId = "123",
            journalposttype = Journalposttype.I,
            journalstatus = Journalstatus.MOTTATT,
            kanal = "NAV_NO",
            dokumenter = null,
        )

        // Act
        val erDigitalSøknad = journalpost.harDigitalSøknad(Tema.BAR)

        // Assert
        assertFalse(erDigitalSøknad)
    }

    @Test
    fun `skal returnere false dersom journalpost ikke har kommet via digital kanal og tema er BAR`() {
        // Arrange
        val journalpost = Journalpost(
            journalpostId = "123",
            journalposttype = Journalposttype.I,
            journalstatus = Journalstatus.MOTTATT,
            kanal = "SKAN_",
            dokumenter = emptyList(),
        )

        // Act
        val erDigitalSøknad = journalpost.harDigitalSøknad(Tema.BAR)

        // Assert
        assertFalse(erDigitalSøknad)
    }

    @Test
    fun `skal kaste feil dersom tema enda ikke er støttet`() {
        // Arrange
        val journalpost = Journalpost(
            journalpostId = "123",
            journalposttype = Journalposttype.I,
            journalstatus = Journalstatus.MOTTATT,
        )

        // Act
        val error = assertThrows<Error> { journalpost.harDigitalSøknad(Tema.ENF) }

        // Assert
        assertEquals(expected = "Støtter ikke tema ${Tema.ENF}", actual = error.message)
    }
}
