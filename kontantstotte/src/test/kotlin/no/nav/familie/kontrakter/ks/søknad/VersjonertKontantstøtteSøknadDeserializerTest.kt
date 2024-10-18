package no.nav.familie.kontrakter.ks.søknad

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.objectMapper
import no.nav.familie.kontrakter.felles.søknad.MissingVersionException
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt
import no.nav.familie.kontrakter.felles.søknad.UnsupportedVersionException
import no.nav.familie.kontrakter.ks.søknad.v1.RegistrertBostedType
import no.nav.familie.kontrakter.ks.søknad.v1.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ks.søknad.v1.SøknadAdresse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertTrue
import no.nav.familie.kontrakter.ks.søknad.v1.Barn as BarnV1
import no.nav.familie.kontrakter.ks.søknad.v1.KontantstøtteSøknad as KontantstøtteSøknadV1
import no.nav.familie.kontrakter.ks.søknad.v1.Søker as SøkerV1
import no.nav.familie.kontrakter.ks.søknad.v2.Barn as BarnV2
import no.nav.familie.kontrakter.ks.søknad.v2.KontantstøtteSøknad as KontantstøtteSøknadV2
import no.nav.familie.kontrakter.ks.søknad.v2.Søker as SøkerV2
import no.nav.familie.kontrakter.ks.søknad.v3.Barn as BarnV3
import no.nav.familie.kontrakter.ks.søknad.v3.KontantstøtteSøknad as KontantstøtteSøknadV3
import no.nav.familie.kontrakter.ks.søknad.v4.Barn as BarnV4
import no.nav.familie.kontrakter.ks.søknad.v4.KontantstøtteSøknad as KontantstøtteSøknadV4
import no.nav.familie.kontrakter.ks.søknad.v4.Søker as SøkerV4
import no.nav.familie.kontrakter.ks.søknad.v5.KontantstøtteSøknad as KontantstøtteSøknadV5

class VersjonertKontantstøtteSøknadDeserializerTest {
    @Test
    fun`skal kunne deserialisere KontantstøtteSøknad V5`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV5 =
            KontantstøtteSøknadV5(
                kontraktVersjon = 5,
                søker = lagSøkerV4(søkerFnr),
                barn = listOf(lagBarnV4(barnFnr)),
                antallEøsSteg = 0,
                dokumentasjon = emptyList(),
                teksterTilPdf = emptyMap(),
                originalSpråk = "NB",
                finnesPersonMedAdressebeskyttelse = false,
                erNoenAvBarnaFosterbarn = lagStringSøknadsfelt("Nei"),
                søktAsylForBarn = lagStringSøknadsfelt("Nei"),
                oppholderBarnSegIInstitusjon = lagStringSøknadsfelt("Nei"),
                barnOppholdtSegTolvMndSammenhengendeINorge = lagStringSøknadsfelt("Ja"),
                erBarnAdoptert = lagStringSøknadsfelt("Nei"),
                mottarKontantstøtteForBarnFraAnnetEøsland = lagStringSøknadsfelt("Nei"),
                harEllerTildeltBarnehageplass = lagStringSøknadsfelt("Nei"),
                erAvdødPartnerForelder = null,
            )
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV5)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV5 }
        assertEquals(5, versjonertKontantstøtteSøknad.baksSøknadBase.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.baksSøknadBase.personerISøknad().size)
        assertEquals(listOf("12345678910", "12345678911"), versjonertKontantstøtteSøknad.baksSøknadBase.personerISøknad())
    }

    @Test
    fun`skal kunne deserialisere KontantstøtteSøknad V4`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV4 =
            KontantstøtteSøknadV4(
                kontraktVersjon = 4,
                søker = lagSøkerV4(søkerFnr),
                barn = listOf(lagBarnV4(barnFnr)),
                antallEøsSteg = 0,
                dokumentasjon = emptyList(),
                teksterTilPdf = emptyMap(),
                originalSpråk = "NB",
                erNoenAvBarnaFosterbarn = lagStringSøknadsfelt("Nei"),
                søktAsylForBarn = lagStringSøknadsfelt("Nei"),
                oppholderBarnSegIInstitusjon = lagStringSøknadsfelt("Nei"),
                barnOppholdtSegTolvMndSammenhengendeINorge = lagStringSøknadsfelt("Ja"),
                erBarnAdoptert = lagStringSøknadsfelt("Nei"),
                mottarKontantstøtteForBarnFraAnnetEøsland = lagStringSøknadsfelt("Nei"),
                harEllerTildeltBarnehageplass = lagStringSøknadsfelt("Nei"),
                erAvdødPartnerForelder = null,
            )
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV4)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV4 }
        assertEquals(4, versjonertKontantstøtteSøknad.baksSøknadBase.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.baksSøknadBase.personerISøknad().size)
        assertEquals(listOf("12345678910", "12345678911"), versjonertKontantstøtteSøknad.baksSøknadBase.personerISøknad())
    }

    @Test
    fun`skal kunne deserialisere KontantstøtteSøknad V3 når kontraktVersjon er 3`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV3 =
            KontantstøtteSøknadV3(
                kontraktVersjon = 3,
                søker = lagSøkerV2(søkerFnr),
                barn = listOf(lagBarnV3(barnFnr)),
                antallEøsSteg = 0,
                dokumentasjon = emptyList(),
                teksterTilPdf = emptyMap(),
                originalSpråk = "NB",
                erNoenAvBarnaFosterbarn = lagStringSøknadsfelt("Nei"),
                søktAsylForBarn = lagStringSøknadsfelt("Nei"),
                oppholderBarnSegIInstitusjon = lagStringSøknadsfelt("Nei"),
                barnOppholdtSegTolvMndSammenhengendeINorge = lagStringSøknadsfelt("Ja"),
                erBarnAdoptert = lagStringSøknadsfelt("Nei"),
                mottarKontantstøtteForBarnFraAnnetEøsland = lagStringSøknadsfelt("Nei"),
                harEllerTildeltBarnehageplass = lagStringSøknadsfelt("Nei"),
                erAvdødPartnerForelder = null,
            )
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV3)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV3 }
        assertEquals(3, versjonertKontantstøtteSøknad.baksSøknadBase.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.baksSøknadBase.personerISøknad().size)
        assertEquals(listOf("12345678910", "12345678911"), versjonertKontantstøtteSøknad.baksSøknadBase.personerISøknad())
    }

    @Test
    fun`skal kunne deserialisere til VersjonertKontantstøtteSøknadV2 når kontraktVersjon er 2`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV2 =
            KontantstøtteSøknadV2(
                kontraktVersjon = 2,
                søker = lagSøkerV2(søkerFnr),
                barn = listOf(lagBarnV2(barnFnr)),
                antallEøsSteg = 0,
                dokumentasjon = emptyList(),
                teksterTilPdf = emptyMap(),
                originalSpråk = "NB",
                erNoenAvBarnaFosterbarn = lagStringSøknadsfelt("Nei"),
                søktAsylForBarn = lagStringSøknadsfelt("Nei"),
                oppholderBarnSegIInstitusjon = lagStringSøknadsfelt("Nei"),
                barnOppholdtSegTolvMndSammenhengendeINorge = lagStringSøknadsfelt("Ja"),
                erBarnAdoptert = lagStringSøknadsfelt("Nei"),
                mottarKontantstøtteForBarnFraAnnetEøsland = lagStringSøknadsfelt("Nei"),
                harEllerTildeltBarnehageplass = lagStringSøknadsfelt("Nei"),
                erAvdødPartnerForelder = null,
            )
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV2)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV2 }
        assertEquals(2, versjonertKontantstøtteSøknad.baksSøknadBase.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.baksSøknadBase.personerISøknad().size)
        assertEquals(listOf("12345678910", "12345678911"), versjonertKontantstøtteSøknad.baksSøknadBase.personerISøknad())
    }

    @Test
    fun`skal kunne deserialisere til VersjonertKontantstøtteSøknadV1 når kontraktVersjon er 1`() {
        // Arrange
        val søkerFnr = "12345678910"
        val barnFnr = "12345678911"
        val kontantstøtteSøknadV1 =
            KontantstøtteSøknadV1(
                kontraktVersjon = 1,
                søker = lagSøkerV1(søkerFnr),
                barn = listOf(lagBarnV1(barnFnr)),
                antallEøsSteg = 0,
                dokumentasjon = emptyList(),
                teksterTilPdf = emptyMap(),
                originalSpråk = "NB",
                erNoenAvBarnaFosterbarn = lagStringSøknadsfelt("Nei"),
                søktAsylForBarn = lagStringSøknadsfelt("Nei"),
                oppholderBarnSegIInstitusjon = lagStringSøknadsfelt("Nei"),
                barnOppholdtSegTolvMndSammenhengendeINorge = lagStringSøknadsfelt("Ja"),
                erBarnAdoptert = lagStringSøknadsfelt("Nei"),
                mottarKontantstøtteForBarnFraAnnetEøsland = lagStringSøknadsfelt("Nei"),
                harEllerTildeltBarnehageplass = lagStringSøknadsfelt("Nei"),
                erAvdødPartnerForelder = null,
            )
        val søknadJson = objectMapper.writeValueAsString(kontantstøtteSøknadV1)

        // Act
        val versjonertKontantstøtteSøknad = objectMapper.readValue<VersjonertKontantstøtteSøknad>(søknadJson)

        // Assert
        assertNotNull(versjonertKontantstøtteSøknad)
        assertTrue { versjonertKontantstøtteSøknad is VersjonertKontantstøtteSøknadV1 }
        assertEquals(1, versjonertKontantstøtteSøknad.baksSøknadBase.kontraktVersjon)
        assertEquals(2, versjonertKontantstøtteSøknad.baksSøknadBase.personerISøknad().size)
        assertEquals(listOf("12345678910", "12345678911"), versjonertKontantstøtteSøknad.baksSøknadBase.personerISøknad())
    }

    @Test
    fun `skal kaste feil UnsupportedVersionException dersom JSON-string ikke inneholder feltet 'kontraktVersjon'`() {
        // Arrange
        val jsonString = """{"felt1":123,"felt2":"hei"}"""

        // Act & Assert
        val missingVersionException =
            assertThrows<MissingVersionException> { objectMapper.readValue<VersjonertKontantstøtteSøknad>(jsonString) }
        assertEquals(
            "JSON-string mangler feltet 'kontraktVersjon' og kan ikke deserialiseres. $jsonString",
            missingVersionException.message,
        )
    }

    @Test
    fun `skal kaste feil UnsupportedVersionException dersom feltet 'kontraktVersjon' ikke er støttet`() {
        // Arrange
        val jsonString = """{"kontraktVersjon":100}"""

        // Act & Assert
        val unsupportedVersionException =
            assertThrows<UnsupportedVersionException> { objectMapper.readValue<VersjonertKontantstøtteSøknad>(jsonString) }
        assertEquals(
            "Mangler implementasjon for versjon: 100 av KontantstøtteSøknad.",
            unsupportedVersionException.message,
        )
    }

    private fun <T> lagStringSøknadsfelt(verdi: T): Søknadsfelt<T> =
        Søknadsfelt(
            label = mapOf("no" to ""),
            verdi = mapOf("no" to verdi),
        )

    private fun lagSøkerV4(fnr: String): SøkerV4 =
        SøkerV4(
            harEøsSteg = false,
            ident = lagStringSøknadsfelt(fnr),
            navn = lagStringSøknadsfelt("Navn"),
            statsborgerskap = lagStringSøknadsfelt(listOf("Norge")),
            adresse =
                lagStringSøknadsfelt(
                    SøknadAdresse(
                        adressenavn = "Gate",
                        postnummer = null,
                        husbokstav = null,
                        bruksenhetsnummer = null,
                        husnummer = null,
                        poststed = null,
                    ),
                ),
            adressebeskyttelse = false,
            sivilstand = lagStringSøknadsfelt(SIVILSTANDTYPE.UOPPGITT),
            borPåRegistrertAdresse = null,
            værtINorgeITolvMåneder = lagStringSøknadsfelt("Ja"),
            planleggerÅBoINorgeTolvMnd = lagStringSøknadsfelt("Ja"),
            yrkesaktivFemÅr = lagStringSøknadsfelt("Ja"),
            erAsylsøker = lagStringSøknadsfelt("Nei"),
            utenlandsoppholdUtenArbeid = lagStringSøknadsfelt("Nei"),
            utenlandsperioder = emptyList(),
            arbeidIUtlandet = lagStringSøknadsfelt("Nei"),
            arbeidsperioderUtland = emptyList(),
            mottarUtenlandspensjon = lagStringSøknadsfelt("Nei"),
            pensjonsperioderUtland = emptyList(),
            arbeidINorge = lagStringSøknadsfelt("Nei"),
            arbeidsperioderNorge = emptyList(),
            pensjonNorge = lagStringSøknadsfelt("Nei"),
            pensjonsperioderNorge = emptyList(),
            andreUtbetalingsperioder = emptyList(),
            idNummer = emptyList(),
            andreUtbetalinger = null,
            adresseISøkeperiode = null,
        )

    private fun lagSøkerV2(fnr: String): SøkerV2 =
        SøkerV2(
            harEøsSteg = false,
            ident = lagStringSøknadsfelt(fnr),
            navn = lagStringSøknadsfelt("Navn"),
            statsborgerskap = lagStringSøknadsfelt(listOf("Norge")),
            adresse =
                lagStringSøknadsfelt(
                    SøknadAdresse(
                        adressenavn = "Gate",
                        postnummer = null,
                        husbokstav = null,
                        bruksenhetsnummer = null,
                        husnummer = null,
                        poststed = null,
                    ),
                ),
            adressebeskyttelse = false,
            sivilstand = lagStringSøknadsfelt(SIVILSTANDTYPE.UOPPGITT),
            borPåRegistrertAdresse = null,
            værtINorgeITolvMåneder = lagStringSøknadsfelt("Ja"),
            planleggerÅBoINorgeTolvMnd = lagStringSøknadsfelt("Ja"),
            yrkesaktivFemÅr = lagStringSøknadsfelt("Ja"),
            erAsylsøker = lagStringSøknadsfelt("Nei"),
            utenlandsperioder = emptyList(),
            arbeidIUtlandet = lagStringSøknadsfelt("Nei"),
            arbeidsperioderUtland = emptyList(),
            mottarUtenlandspensjon = lagStringSøknadsfelt("Nei"),
            pensjonsperioderUtland = emptyList(),
            arbeidINorge = lagStringSøknadsfelt("Nei"),
            arbeidsperioderNorge = emptyList(),
            pensjonNorge = lagStringSøknadsfelt("Nei"),
            pensjonsperioderNorge = emptyList(),
            andreUtbetalingsperioder = emptyList(),
            idNummer = emptyList(),
            andreUtbetalinger = null,
            adresseISøkeperiode = null,
        )

    private fun lagSøkerV1(fnr: String): SøkerV1 =
        SøkerV1(
            harEøsSteg = false,
            ident = lagStringSøknadsfelt(fnr),
            navn = lagStringSøknadsfelt("Navn"),
            statsborgerskap = lagStringSøknadsfelt(listOf("Norge")),
            adresse =
                lagStringSøknadsfelt(
                    SøknadAdresse(
                        adressenavn = "Gate",
                        postnummer = null,
                        husbokstav = null,
                        bruksenhetsnummer = null,
                        husnummer = null,
                        poststed = null,
                    ),
                ),
            adressebeskyttelse = false,
            sivilstand = lagStringSøknadsfelt(SIVILSTANDTYPE.UOPPGITT),
            borPåRegistrertAdresse = null,
            værtINorgeITolvMåneder = lagStringSøknadsfelt("Ja"),
            planleggerÅBoINorgeTolvMnd = lagStringSøknadsfelt("Ja"),
            yrkesaktivFemÅr = lagStringSøknadsfelt("Ja"),
            erAsylsøker = lagStringSøknadsfelt("Nei"),
            utenlandsperioder = emptyList(),
            arbeidIUtlandet = lagStringSøknadsfelt("Nei"),
            arbeidsperioderUtland = emptyList(),
            mottarUtenlandspensjon = lagStringSøknadsfelt("Nei"),
            pensjonsperioderUtland = emptyList(),
            arbeidINorge = lagStringSøknadsfelt("Nei"),
            arbeidsperioderNorge = emptyList(),
            pensjonNorge = lagStringSøknadsfelt("Nei"),
            pensjonsperioderNorge = emptyList(),
            andreUtbetalingsperioder = emptyList(),
            idNummer = emptyList(),
            andreUtbetalinger = null,
            adresseISøkeperiode = null,
        )

    private fun lagBarnV4(fnr: String): BarnV4 =
        BarnV4(
            harEøsSteg = false,
            ident = lagStringSøknadsfelt(fnr),
            navn = lagStringSøknadsfelt(""),
            registrertBostedType = lagStringSøknadsfelt(RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
            alder = null,
            teksterTilPdf = emptyMap(),
            erFosterbarn = lagStringSøknadsfelt("Nei"),
            oppholderSegIInstitusjon = lagStringSøknadsfelt("Nei"),
            erAdoptert = lagStringSøknadsfelt("Nei"),
            erAsylsøker = lagStringSøknadsfelt("Nei"),
            boddMindreEnn12MndINorge = lagStringSøknadsfelt("Nei"),
            kontantstøtteFraAnnetEøsland = lagStringSøknadsfelt("Nei"),
            harBarnehageplass = lagStringSøknadsfelt("Nei"),
            andreForelderErDød = null,
            utbetaltForeldrepengerEllerEngangsstønad = null,
            mottarEllerMottokEøsKontantstøtte = null,
            pågåendeSøknadFraAnnetEøsLand = null,
            pågåendeSøknadHvilketLand = null,
            planleggerÅBoINorge12Mnd = null,
            eøsKontantstøttePerioder = emptyList(),
            barnehageplassPerioder = emptyList(),
            borFastMedSøker = lagStringSøknadsfelt("Ja"),
            foreldreBorSammen = null,
            søkerDeltKontantstøtte = null,
            andreForelder = null,
            utenlandsperioder = emptyList(),
            søkersSlektsforhold = null,
            søkersSlektsforholdSpesifisering = null,
            borMedAndreForelder = null,
            borMedOmsorgsperson = null,
            adresse = null,
            omsorgsperson = null,
            idNummer = emptyList(),
        )

    private fun lagBarnV3(fnr: String): BarnV3 =
        BarnV3(
            harEøsSteg = false,
            ident = lagStringSøknadsfelt(fnr),
            navn = lagStringSøknadsfelt(""),
            registrertBostedType = lagStringSøknadsfelt(RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
            alder = null,
            teksterTilPdf = emptyMap(),
            erFosterbarn = lagStringSøknadsfelt("Nei"),
            oppholderSegIInstitusjon = lagStringSøknadsfelt("Nei"),
            erAdoptert = lagStringSøknadsfelt("Nei"),
            erAsylsøker = lagStringSøknadsfelt("Nei"),
            boddMindreEnn12MndINorge = lagStringSøknadsfelt("Nei"),
            kontantstøtteFraAnnetEøsland = lagStringSøknadsfelt("Nei"),
            harBarnehageplass = lagStringSøknadsfelt("Nei"),
            andreForelderErDød = null,
            utbetaltForeldrepengerEllerEngangsstønad = null,
            mottarEllerMottokEøsKontantstøtte = null,
            pågåendeSøknadFraAnnetEøsLand = null,
            pågåendeSøknadHvilketLand = null,
            planleggerÅBoINorge12Mnd = null,
            eøsKontantstøttePerioder = emptyList(),
            barnehageplassPerioder = emptyList(),
            borFastMedSøker = lagStringSøknadsfelt("Ja"),
            foreldreBorSammen = null,
            søkerDeltKontantstøtte = null,
            andreForelder = null,
            utenlandsperioder = emptyList(),
            søkersSlektsforhold = null,
            søkersSlektsforholdSpesifisering = null,
            borMedAndreForelder = null,
            borMedOmsorgsperson = null,
            adresse = null,
            omsorgsperson = null,
            idNummer = emptyList(),
        )

    private fun lagBarnV2(fnr: String): BarnV2 =
        BarnV2(
            harEøsSteg = false,
            ident = lagStringSøknadsfelt(fnr),
            navn = lagStringSøknadsfelt(""),
            registrertBostedType = lagStringSøknadsfelt(RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
            alder = null,
            teksterTilPdf = emptyMap(),
            erFosterbarn = lagStringSøknadsfelt("Nei"),
            oppholderSegIInstitusjon = lagStringSøknadsfelt("Nei"),
            erAdoptert = lagStringSøknadsfelt("Nei"),
            erAsylsøker = lagStringSøknadsfelt("Nei"),
            boddMindreEnn12MndINorge = lagStringSøknadsfelt("Nei"),
            kontantstøtteFraAnnetEøsland = lagStringSøknadsfelt("Nei"),
            harBarnehageplass = lagStringSøknadsfelt("Nei"),
            andreForelderErDød = null,
            utbetaltForeldrepengerEllerEngangsstønad = null,
            mottarEllerMottokEøsKontantstøtte = null,
            pågåendeSøknadFraAnnetEøsLand = null,
            pågåendeSøknadHvilketLand = null,
            planleggerÅBoINorge12Mnd = null,
            eøsKontantstøttePerioder = emptyList(),
            barnehageplassPerioder = emptyList(),
            borFastMedSøker = lagStringSøknadsfelt("Ja"),
            andreForelder = null,
            utenlandsperioder = emptyList(),
            søkersSlektsforhold = null,
            søkersSlektsforholdSpesifisering = null,
            borMedAndreForelder = null,
            borMedOmsorgsperson = null,
            adresse = null,
            omsorgsperson = null,
            idNummer = emptyList(),
        )

    private fun lagBarnV1(fnr: String): BarnV1 =
        BarnV1(
            harEøsSteg = false,
            ident = lagStringSøknadsfelt(fnr),
            navn = lagStringSøknadsfelt(""),
            registrertBostedType = lagStringSøknadsfelt(RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
            alder = null,
            teksterTilPdf = emptyMap(),
            erFosterbarn = lagStringSøknadsfelt("Nei"),
            oppholderSegIInstitusjon = lagStringSøknadsfelt("Nei"),
            erAdoptert = lagStringSøknadsfelt("Nei"),
            erAsylsøker = lagStringSøknadsfelt("Nei"),
            boddMindreEnn12MndINorge = lagStringSøknadsfelt("Nei"),
            kontantstøtteFraAnnetEøsland = lagStringSøknadsfelt("Nei"),
            harBarnehageplass = lagStringSøknadsfelt("Nei"),
            andreForelderErDød = null,
            utbetaltForeldrepengerEllerEngangsstønad = null,
            mottarEllerMottokEøsKontantstøtte = null,
            pågåendeSøknadFraAnnetEøsLand = null,
            pågåendeSøknadHvilketLand = null,
            planleggerÅBoINorge12Mnd = null,
            eøsKontantstøttePerioder = emptyList(),
            barnehageplassPerioder = emptyList(),
            borFastMedSøker = lagStringSøknadsfelt("Ja"),
            andreForelder = null,
            utenlandsperioder = emptyList(),
            søkersSlektsforhold = null,
            søkersSlektsforholdSpesifisering = null,
            borMedAndreForelder = null,
            borMedOmsorgsperson = null,
            adresse = null,
            omsorgsperson = null,
            idNummer = emptyList(),
        )
}
