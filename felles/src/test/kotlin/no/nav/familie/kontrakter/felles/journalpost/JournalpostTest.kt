package no.nav.familie.kontrakter.felles.journalpost

import no.nav.familie.kontrakter.felles.Brevkoder
import no.nav.familie.kontrakter.felles.Tema
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertNull

class JournalpostTest {
    @Nested
    inner class DatoMottattTest {
        @Test
        fun `skal returnere null om relevante datoer er tom`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    relevanteDatoer = emptyList(),
                )

            // Act
            val datoMottatt = journalpost.datoMottatt

            // Assert
            assertNull(datoMottatt)
        }

        @Test
        fun `skal returnere null om relevante datoer ikke har riktig datotype`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    relevanteDatoer =
                    listOf(
                        RelevantDato(
                            dato = LocalDateTime.of(2024, 8, 1, 12, 0),
                            datotype = "FEIL_DATOTYPE",
                        ),
                    ),
                )

            // Act
            val datoMottatt = journalpost.datoMottatt

            // Assert
            assertNull(datoMottatt)
        }

        @Test
        fun `skal returnere mottatt dato`() {
            // Arrange
            val enDato = LocalDateTime.of(2024, 8, 1, 12, 0)

            val journalpost =
                lagJournalpost(
                    relevanteDatoer =
                    listOf(
                        RelevantDato(
                            dato = enDato,
                            datotype = "DATO_REGISTRERT",
                        ),
                    ),
                )

            // Act
            val datoMottatt = journalpost.datoMottatt

            // Assert
            assertEquals(datoMottatt, enDato)
        }
    }

    @Nested
    inner class ErDigitalKanalTest {
        @Test
        fun `skal returnere false om kanal ikke er NAV_NO`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "IKKE_NAV_NO",
                )

            // Act
            val erDigitalKanal = journalpost.erDigitalKanal()

            // Assert
            assertFalse(erDigitalKanal)
        }

        @Test
        fun `skal returnere false om kanal er NAV_NO`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "NAV_NO",
                )

            // Act
            val erDigitalKanal = journalpost.erDigitalKanal()

            // Assert
            assertTrue(erDigitalKanal)
        }
    }

    @Nested
    inner class HarKontantstøtteSøknadTest {
        @Test
        fun `skal returnere false dokumenter er null`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter = null,
                )

            // Act
            val harKontantstøtteSøknad = journalpost.harKontantstøtteSøknad()

            // Assert
            assertFalse(harKontantstøtteSøknad)
        }

        @Test
        fun `skal returnere false dokumenter er tom`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter = emptyList(),
                )

            // Act
            val harKontantstøtteSøknad = journalpost.harKontantstøtteSøknad()

            // Assert
            assertFalse(harKontantstøtteSøknad)
        }

        @Test
        fun `skal returnere false dokumenter ikke inneholder søknad for kontatsøttte`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harKontantstøtteSøknad = journalpost.harKontantstøtteSøknad()

            // Assert
            assertFalse(harKontantstøtteSøknad)
        }

        @Test
        fun `skal returnere true om journalpost har søknad for kontatstøtte`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harKontantstøtteSøknad = journalpost.harKontantstøtteSøknad()

            // Assert
            assertTrue(harKontantstøtteSøknad)
        }
    }

    @Nested
    inner class HarBarnetrygdOrdinærSøknadTest {
        @Test
        fun `skal returnere false dokumenter er null`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter = null,
                )

            // Act
            val harBarnetrygdOrdinærSøknad = journalpost.harBarnetrygdOrdinærSøknad()

            // Assert
            assertFalse(harBarnetrygdOrdinærSøknad)
        }

        @Test
        fun `skal returnere false dokumenter er tom`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter = emptyList(),
                )

            // Act
            val harBarnetrygdOrdinærSøknad = journalpost.harBarnetrygdOrdinærSøknad()

            // Assert
            assertFalse(harBarnetrygdOrdinærSøknad)
        }

        @Test
        fun `skal returnere false dokumenter ikke inneholder søknad for ordinær barnetrygd`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harBarnetrygdOrdinærSøknad = journalpost.harBarnetrygdOrdinærSøknad()

            // Assert
            assertFalse(harBarnetrygdOrdinærSøknad)
        }

        @Test
        fun `skal returnere true om journalpost har søknad for ordinær barnetrygd`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harBarnetrygdOrdinærSøknad = journalpost.harBarnetrygdOrdinærSøknad()

            // Assert
            assertTrue(harBarnetrygdOrdinærSøknad)
        }
    }

    @Nested
    inner class HarBarnetrygdUtvidetSøknadTest {
        @Test
        fun `skal returnere false dokumenter er null`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter = null,
                )

            // Act
            val harBarnetrygdUtvidetSøknad = journalpost.harBarnetrygdUtvidetSøknad()

            // Assert
            assertFalse(harBarnetrygdUtvidetSøknad)
        }

        @Test
        fun `skal returnere false dokumenter er tom`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter = emptyList(),
                )

            // Act
            val harBarnetrygdUtvidetSøknad = journalpost.harBarnetrygdUtvidetSøknad()

            // Assert
            assertFalse(harBarnetrygdUtvidetSøknad)
        }

        @Test
        fun `skal returnere false dokumenter ikke inneholder søknad for utvidet barnetrygd`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harBarnetrygdUtvidetSøknad = journalpost.harBarnetrygdUtvidetSøknad()

            // Assert
            assertFalse(harBarnetrygdUtvidetSøknad)
        }

        @Test
        fun `skal returnere true om journalpost har søknad for utvidet barnetrygd`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.BARNETRYGD_UTVIDET_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harBarnetrygdUtvidetSøknad = journalpost.harBarnetrygdUtvidetSøknad()

            // Assert
            assertTrue(harBarnetrygdUtvidetSøknad)
        }
    }

    @Nested
    inner class HarBarnetrygdSøknadTest {
        @Test
        fun `skal returnere false om dokumenter hver har søknad for ordinær eller utvidet barnetrygd`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harBarnetrygdSøknad = journalpost.harBarnetrygdSøknad()

            // Assert
            assertFalse(harBarnetrygdSøknad)
        }

        @Test
        fun `skal returnere true om dokumenter har søknad for ordinær barnetrygd`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harBarnetrygdSøknad = journalpost.harBarnetrygdSøknad()

            // Assert
            assertTrue(harBarnetrygdSøknad)
        }

        @Test
        fun `skal returnere true om dokumenter har søknad for utvidet barnetrygd`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.BARNETRYGD_UTVIDET_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harBarnetrygdSøknad = journalpost.harBarnetrygdSøknad()

            // Assert
            assertTrue(harBarnetrygdSøknad)
        }

        @Test
        fun `skal returnere true om dokumenter har søknad for både ordinær og utvidet barnetrygd`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.BARNETRYGD_UTVIDET_SØKNAD,
                        ),
                        DokumentInfo(
                            dokumentInfoId = "2",
                            brevkode = Brevkoder.BARNETRYGD_UTVIDET_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harBarnetrygdSøknad = journalpost.harBarnetrygdSøknad()

            // Assert
            assertTrue(harBarnetrygdSøknad)
        }
    }

    @Nested
    inner class HarDigitalBarnetrygdSøknadTest {
        @Test
        fun `skal returnere false om det ikke er en digital søknad`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "IKKE_NAV_NO",
                )

            // Act
            val harDigitalBarnetrygdSøknad = journalpost.harDigitalBarnetrygdSøknad()

            // Assert
            assertFalse(harDigitalBarnetrygdSøknad)
        }

        @Test
        fun `skal returnere false om dokumenter er null`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "NAV_NO",
                    dokumenter = null,
                )

            // Act
            val harDigitalBarnetrygdSøknad = journalpost.harDigitalBarnetrygdSøknad()

            // Assert
            assertFalse(harDigitalBarnetrygdSøknad)
        }

        @Test
        fun `skal returnere false om dokumenter er tom`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "NAV_NO",
                    dokumenter = emptyList(),
                )

            // Act
            val harDigitalBarnetrygdSøknad = journalpost.harDigitalBarnetrygdSøknad()

            // Assert
            assertFalse(harDigitalBarnetrygdSøknad)
        }

        @Test
        fun `skal returnere false om dokumenter ikke inneholder søknad for barnetrygd`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "NAV_NO",
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harDigitalBarnetrygdSøknad = journalpost.harDigitalBarnetrygdSøknad()

            // Assert
            assertFalse(harDigitalBarnetrygdSøknad)
        }

        @Test
        fun `skal returnere true om dokumenter inneholder søknad for barnetrygd`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "NAV_NO",
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harDigitalBarnetrygdSøknad = journalpost.harDigitalBarnetrygdSøknad()

            // Assert
            assertTrue(harDigitalBarnetrygdSøknad)
        }
    }

    @Nested
    inner class HarDigitalKontantstøtteSøknadTest {
        @Test
        fun `skal returnere false om det ikke er en digital søknad`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "IKKE_NAV_NO",
                )

            // Act
            val harDigitalKontantstøtteSøknad = journalpost.harDigitalKontantstøtteSøknad()

            // Assert
            assertFalse(harDigitalKontantstøtteSøknad)
        }

        @Test
        fun `skal returnere false om dokumenter er null`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "NAV_NO",
                    dokumenter = null,
                )

            // Act
            val harDigitalKontantstøtteSøknad = journalpost.harDigitalKontantstøtteSøknad()

            // Assert
            assertFalse(harDigitalKontantstøtteSøknad)
        }

        @Test
        fun `skal returnere false om dokumenter er tom`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "NAV_NO",
                    dokumenter = emptyList(),
                )

            // Act
            val harDigitalKontantstøtteSøknad = journalpost.harDigitalKontantstøtteSøknad()

            // Assert
            assertFalse(harDigitalKontantstøtteSøknad)
        }

        @Test
        fun `skal returnere false om dokumenter ikke inneholder søknad for kontatstøtte`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "NAV_NO",
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.BARNETRYGD_ORDINÆR_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harDigitalKontantstøtteSøknad = journalpost.harDigitalKontantstøtteSøknad()

            // Assert
            assertFalse(harDigitalKontantstøtteSøknad)
        }

        @Test
        fun `skal returnere true om dokumenter inneholder søknad for kontatstøtte`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    kanal = "NAV_NO",
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = Brevkoder.KONTANTSTØTTE_SØKNAD,
                        ),
                    ),
                )

            // Act
            val harDigitalKontantstøtteSøknad = journalpost.harDigitalKontantstøtteSøknad()

            // Assert
            assertTrue(harDigitalKontantstøtteSøknad)
        }
    }

    @Nested
    inner class HarDigitalSøknadTest {
        @Test
        fun `skal returnere true dersom journalpost er digital kontantstøtte søknad og tema er KON`() {
            // Arrange
            val journalpost =
                Journalpost(
                    journalpostId = "123",
                    journalposttype = Journalposttype.I,
                    journalstatus = Journalstatus.MOTTATT,
                    kanal = "NAV_NO",
                    dokumenter =
                    listOf(
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
            val journalpost =
                Journalpost(
                    journalpostId = "123",
                    journalposttype = Journalposttype.I,
                    journalstatus = Journalstatus.MOTTATT,
                    kanal = "NAV_NO",
                    dokumenter =
                    listOf(
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
            val journalpost =
                Journalpost(
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
            val journalpost =
                Journalpost(
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
            val journalpost =
                Journalpost(
                    journalpostId = "123",
                    journalposttype = Journalposttype.I,
                    journalstatus = Journalstatus.MOTTATT,
                    kanal = "NAV_NO",
                    dokumenter =
                    listOf(
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
            val journalpost =
                Journalpost(
                    journalpostId = "123",
                    journalposttype = Journalposttype.I,
                    journalstatus = Journalstatus.MOTTATT,
                    kanal = "NAV_NO",
                    dokumenter =
                    listOf(
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
            val journalpost =
                Journalpost(
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
            val journalpost =
                Journalpost(
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
            val journalpost =
                Journalpost(
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

    @Nested
    inner class HentHovedDokumentTittelTest {
        @Test
        fun `skal kaste exception om dokumenter er null`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter = null,
                )

            // Act & assert
            val exception =
                assertThrows<IllegalStateException> {
                    journalpost.hentHovedDokumentTittel()
                }
            assertEquals(exception.message, "Journalpost ${journalpost.journalpostId} mangler dokumenter")
        }

        @Test
        fun `skal kaste exception om dokumenter er tom`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter = emptyList(),
                )

            // Act & assert
            val exception =
                assertThrows<IllegalStateException> {
                    journalpost.hentHovedDokumentTittel()
                }
            assertEquals(exception.message, "Journalpost ${journalpost.journalpostId} mangler dokumenter")
        }

        @Test
        fun `skal returnere null om brevkode er null`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = null,
                        ),
                    ),
                )

            // Act
            val hovedDokumentTittel = journalpost.hentHovedDokumentTittel()

            // Assert
            assertNull(hovedDokumentTittel)
        }

        @Test
        fun `skal returnere null om tittel er null for dokumentinfo`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = null,
                            tittel = "AAA",
                        ),
                        DokumentInfo(
                            dokumentInfoId = "2",
                            brevkode = "2",
                            tittel = null,
                        ),
                        DokumentInfo(
                            dokumentInfoId = "3",
                            brevkode = "1",
                            tittel = "CCC",
                        ),
                    ),
                )

            // Act
            val hovedDokumentTittel = journalpost.hentHovedDokumentTittel()

            // Assert
            assertNull(hovedDokumentTittel)
        }

        @Test
        fun `skal returnere hoved dokument tittel`() {
            // Arrange
            val journalpost =
                lagJournalpost(
                    dokumenter =
                    listOf(
                        DokumentInfo(
                            dokumentInfoId = "1",
                            brevkode = null,
                            tittel = "AAA",
                        ),
                        DokumentInfo(
                            dokumentInfoId = "2",
                            brevkode = "2",
                            tittel = "BBB",
                        ),
                        DokumentInfo(
                            dokumentInfoId = "3",
                            brevkode = "1",
                            tittel = "CCC",
                        ),
                    ),
                )

            // Act
            val hovedDokumentTittel = journalpost.hentHovedDokumentTittel()

            // Assert
            assertEquals(hovedDokumentTittel, "BBB")
        }
    }

    private fun lagJournalpost(
        journalpostId: String = "123",
        journalposttype: Journalposttype = Journalposttype.I,
        journalstatus: Journalstatus = Journalstatus.MOTTATT,
        kanal: String = "NAV_NO",
        dokumenter: List<DokumentInfo>? = null,
        relevanteDatoer: List<RelevantDato>? = null,
    ) = Journalpost(
        journalpostId = journalpostId,
        journalposttype = journalposttype,
        journalstatus = journalstatus,
        kanal = kanal,
        dokumenter = dokumenter,
        relevanteDatoer = relevanteDatoer,
    )
}
