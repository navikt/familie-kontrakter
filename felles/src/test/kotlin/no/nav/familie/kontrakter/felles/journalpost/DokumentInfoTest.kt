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
    inner class ErBarnetrygdOrdinærSøknadTest {
        @Test
        fun `skal returnere true om brevkode er for ordinær barnetrygd søknad`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                )

            // Act
            val erBarnetrygdOrdinærSøknad = dokumentInfo.erBarnetrygdOrdinærSøknad()

            // Assert
            assertTrue(erBarnetrygdOrdinærSøknad)
        }

        @Test
        fun `skal returnere false om brevkode ikke er for ordinær barnetrygd søknad`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_UTVIDET_SØKNAD,
                )

            // Act
            val erBarnetrygdOrdinærSøknad = dokumentInfo.erBarnetrygdOrdinærSøknad()

            // Assert
            assertFalse(erBarnetrygdOrdinærSøknad)
        }

        @Test
        fun `skal returnere false om brevkode er null`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = null,
                )

            // Act
            val erBarnetrygdOrdinærSøknad = dokumentInfo.erBarnetrygdOrdinærSøknad()

            // Assert
            assertFalse(erBarnetrygdOrdinærSøknad)
        }
    }

    @Nested
    inner class ErBarnetrygdUtvidetSøknadTest {
        @Test
        fun `skal returnere true om brevkode er for utvidet barnetrygd søknad`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_UTVIDET_SØKNAD,
                )

            // Act
            val erBarnetrygdUtvidetSøknad = dokumentInfo.erBarnetrygdUtvidetSøknad()

            // Assert
            assertTrue(erBarnetrygdUtvidetSøknad)
        }

        @Test
        fun `skal returnere false om brevkode ikke er for utvidet barnetrygd søknad`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                )

            // Act
            val erBarnetrygdUtvidetSøknad = dokumentInfo.erBarnetrygdUtvidetSøknad()

            // Assert
            assertFalse(erBarnetrygdUtvidetSøknad)
        }

        @Test
        fun `skal returnere false om brevkode er null`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = null,
                )

            // Act
            val erBarnetrygdUtvidetSøknad = dokumentInfo.erBarnetrygdUtvidetSøknad()

            // Assert
            assertFalse(erBarnetrygdUtvidetSøknad)
        }
    }

    @Nested
    inner class ErBarnetrygdSøknadTest {
        @Test
        fun `skal returnere true om brevkode er utvidet barnetrygd søknad`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_UTVIDET_SØKNAD,
                )

            // Act
            val erBarnetrygdUtvidetSøknad = dokumentInfo.erBarnetrygdSøknad()

            // Assert
            assertTrue(erBarnetrygdUtvidetSøknad)
        }

        @Test
        fun `skal returnere true om brevkode er ordinær barnetrygd søknad`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                )

            // Act
            val erBarnetrygdUtvidetSøknad = dokumentInfo.erBarnetrygdSøknad()

            // Assert
            assertTrue(erBarnetrygdUtvidetSøknad)
        }

        @Test
        fun `skal returnere false om brevkode er for noe annet enn barnetrygd`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                )

            // Act
            val erBarnetrygdUtvidetSøknad = dokumentInfo.erBarnetrygdSøknad()

            // Assert
            assertFalse(erBarnetrygdUtvidetSøknad)
        }

        @Test
        fun `skal returnere false om brevkode er null`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = null,
                )

            // Act
            val erBarnetrygdUtvidetSøknad = dokumentInfo.erBarnetrygdSøknad()

            // Assert
            assertFalse(erBarnetrygdUtvidetSøknad)
        }
    }

    @Nested
    inner class ErKontantstøtteSøknadTest {
        @Test
        fun `skal returnere true om brevkode er for kontantstøtte`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                )

            // Act
            val erKontantstøtteSøknad = dokumentInfo.erKontantstøtteSøknad()

            // Assert
            assertTrue(erKontantstøtteSøknad)
        }

        @Test
        fun `skal returnere false om brevkode ikke er for kontantstøtte søknad`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_UTVIDET_SØKNAD,
                )

            // Act
            val erKontantstøtteSøknad = dokumentInfo.erKontantstøtteSøknad()

            // Assert
            assertFalse(erKontantstøtteSøknad)
        }

        @Test
        fun `skal returnere false om brevkode er null`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = null,
                )

            // Act
            val erKontantstøtteSøknad = dokumentInfo.erKontantstøtteSøknad()

            // Assert
            assertFalse(erKontantstøtteSøknad)
        }
    }

    @Nested
    inner class ErSøknadForTemaTest {
        @Test
        fun `skal returnere true dersom DokumentInfo har brevkode som passer med tema BAR`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                )

            // Act & Assert
            assertTrue { dokumentInfo.erSøknadForTema(Tema.BAR) }
        }

        @Test
        fun `skal returnere false dersom DokumentInfo har brevkode som ikke passer med tema BAR`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                )

            // Act & Assert
            assertFalse { dokumentInfo.erSøknadForTema(Tema.BAR) }
        }

        @Test
        fun `skal returnere true dersom DokumentInfo har brevkode som passer med tema KON`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                )

            // Act & Assert
            assertTrue { dokumentInfo.erSøknadForTema(Tema.KON) }
        }

        @Test
        fun `skal returnere false dersom DokumentInfo har brevkode som ikke passer med tema KON`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_UTVIDET_SØKNAD,
                )

            // Act & Assert
            assertFalse { dokumentInfo.erSøknadForTema(Tema.KON) }
        }

        @Test
        fun `skal kaste feil dersom tema ikke er støttet`() {
            // Arrange
            val dokumentInfo =
                DokumentInfo(
                    dokumentInfoId = "1",
                    brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                )

            // Act & Assert
            val error = assertThrows<Error> { dokumentInfo.erSøknadForTema(Tema.ENF) }
            assertEquals("Støtter ikke tema ENF", error.message)
        }
    }
}
