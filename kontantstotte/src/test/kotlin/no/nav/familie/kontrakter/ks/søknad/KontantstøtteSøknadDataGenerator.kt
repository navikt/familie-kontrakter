package no.nav.familie.kontrakter.ks.søknad

import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt
import no.nav.familie.kontrakter.ks.søknad.v1.RegistrertBostedType
import no.nav.familie.kontrakter.ks.søknad.v1.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ks.søknad.v1.SøknadAdresse
import no.nav.familie.kontrakter.ks.søknad.v1.TekstPåSpråkMap
import no.nav.familie.kontrakter.ks.søknad.v4.Barn as BarnV4
import no.nav.familie.kontrakter.ks.søknad.v6.Barn as BarnV6
import no.nav.familie.kontrakter.ks.søknad.v4.Søker
import no.nav.familie.kontrakter.ks.søknad.v1.KontantstøtteSøknad as KontantstøtteSøknadV1
import no.nav.familie.kontrakter.ks.søknad.v2.KontantstøtteSøknad as KontantstøtteSøknadV2
import no.nav.familie.kontrakter.ks.søknad.v3.KontantstøtteSøknad as KontantstøtteSøknadV3
import no.nav.familie.kontrakter.ks.søknad.v4.KontantstøtteSøknad as KontantstøtteSøknadV4
import no.nav.familie.kontrakter.ks.søknad.v5.KontantstøtteSøknad as KontantstøtteSøknadV5
import no.nav.familie.kontrakter.ks.søknad.v6.KontantstøtteSøknad as KontantstøtteSøknadV6

fun lagKontantstøtteSøknadV6(
    søkerFnr: String,
    barnFnr: String,
): KontantstøtteSøknadV6 =
    KontantstøtteSøknadV6(
        kontraktVersjon = 6,
        søker = lagSøkerV4(søkerFnr),
        barn = listOf(lagBarnV6(barnFnr)),
        antallEøsSteg = 0,
        dokumentasjon = emptyList(),
        teksterTilPdf =
            mapOf(
                "testApiNavn" to TekstPåSpråkMap(mapOf("nb" to "bokmål", "nn" to "nynorsk", "en" to "engelsk")),
            ),
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

fun lagKontantstøtteSøknadV5(
    søkerFnr: String,
    barnFnr: String,
): KontantstøtteSøknadV5 =
    KontantstøtteSøknadV5(
        kontraktVersjon = 5,
        søker = lagSøkerV4(søkerFnr),
        barn = listOf(lagBarnV4(barnFnr)),
        antallEøsSteg = 0,
        dokumentasjon = emptyList(),
        teksterTilPdf =
            mapOf(
                "testApiNavn" to TekstPåSpråkMap(mapOf("nb" to "bokmål", "nn" to "nynorsk", "en" to "engelsk")),
            ),
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

fun lagKontantstøtteSøknadV4(
    søkerFnr: String,
    barnFnr: String,
): KontantstøtteSøknadV4 =
    KontantstøtteSøknadV4(
        kontraktVersjon = 4,
        søker = lagSøkerV4(søkerFnr),
        barn = listOf(lagBarnV4(barnFnr)),
        antallEøsSteg = 0,
        dokumentasjon = emptyList(),
        teksterTilPdf =
            mapOf(
                "testApiNavn" to TekstPåSpråkMap(mapOf("nb" to "bokmål", "nn" to "nynorsk", "en" to "engelsk")),
            ),
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

fun lagKontantstøtteSøknadV3(
    søkerFnr: String,
    barnFnr: String,
): KontantstøtteSøknadV3 =
    KontantstøtteSøknadV3(
        kontraktVersjon = 3,
        søker = lagSøkerV2(søkerFnr),
        barn = listOf(lagBarnV3(barnFnr)),
        antallEøsSteg = 0,
        dokumentasjon = emptyList(),
        teksterTilPdf =
            mapOf(
                "testApiNavn" to TekstPåSpråkMap(mapOf("nb" to "bokmål", "nn" to "nynorsk", "en" to "engelsk")),
            ),
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

fun lagKontantstøtteSøknadV2(
    søkerFnr: String,
    barnFnr: String,
): KontantstøtteSøknadV2 =
    KontantstøtteSøknadV2(
        kontraktVersjon = 2,
        søker = lagSøkerV2(søkerFnr),
        barn = listOf(lagBarnV2(barnFnr)),
        antallEøsSteg = 0,
        dokumentasjon = emptyList(),
        teksterTilPdf =
            mapOf(
                "testApiNavn" to TekstPåSpråkMap(mapOf("nb" to "bokmål", "nn" to "nynorsk", "en" to "engelsk")),
            ),
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

fun lagKontantstøtteSøknadV1(
    søkerFnr: String,
    barnFnr: String,
): KontantstøtteSøknadV1 =
    KontantstøtteSøknadV1(
        kontraktVersjon = 1,
        søker = lagSøkerV1(søkerFnr),
        barn = listOf(lagBarnV1(barnFnr)),
        antallEøsSteg = 0,
        dokumentasjon = emptyList(),
        teksterTilPdf =
            mapOf(
                "testApiNavn" to TekstPåSpråkMap(mapOf("nb" to "bokmål", "nn" to "nynorsk", "en" to "engelsk")),
            ),
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

fun <T> lagStringSøknadsfelt(verdi: T): Søknadsfelt<T> =
    Søknadsfelt(
        label = mapOf("no" to ""),
        verdi = mapOf("no" to verdi),
    )

fun lagSøkerV4(fnr: String): Søker =
    Søker(
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

fun lagSøkerV2(fnr: String): no.nav.familie.kontrakter.ks.søknad.v2.Søker =
    no.nav.familie.kontrakter.ks.søknad.v2.Søker(
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

fun lagSøkerV1(fnr: String): no.nav.familie.kontrakter.ks.søknad.v1.Søker =
    no.nav.familie.kontrakter.ks.søknad.v1.Søker(
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

fun lagBarnV6(fnr: String): BarnV6 =
    BarnV6(
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

fun lagBarnV4(fnr: String): BarnV4 =
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

fun lagBarnV3(fnr: String): no.nav.familie.kontrakter.ks.søknad.v3.Barn =
    no.nav.familie.kontrakter.ks.søknad.v3.Barn(
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

fun lagBarnV2(fnr: String): no.nav.familie.kontrakter.ks.søknad.v2.Barn =
    no.nav.familie.kontrakter.ks.søknad.v2.Barn(
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

fun lagBarnV1(fnr: String): no.nav.familie.kontrakter.ks.søknad.v1.Barn =
    no.nav.familie.kontrakter.ks.søknad.v1.Barn(
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
