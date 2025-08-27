package no.nav.familie.kontrakter.ba.søknad

import no.nav.familie.kontrakter.ba.søknad.v1.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ba.søknad.v1.SøknadAdresse
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.v5.RegistrertBostedType
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v10.BarnetrygdSøknad as BarnetrygdSøknadV10
import no.nav.familie.kontrakter.ba.søknad.v10.Søker as SøkerV10
import no.nav.familie.kontrakter.ba.søknad.v7.Barn as BarnV7
import no.nav.familie.kontrakter.ba.søknad.v7.Søker as SøkerV7
import no.nav.familie.kontrakter.ba.søknad.v7.Søknad as BarnetrygdSøknadV7
import no.nav.familie.kontrakter.ba.søknad.v8.Barn as BarnV8
import no.nav.familie.kontrakter.ba.søknad.v8.Søker as SøkerV8
import no.nav.familie.kontrakter.ba.søknad.v8.Søknad as BarnetrygdSøknadV8
import no.nav.familie.kontrakter.ba.søknad.v9.BarnetrygdSøknad as BarnetrygdSøknadV9

fun lagBarnetrygdSøknadV10(
    søkerFnr: String,
    barnFnr: String,
): BarnetrygdSøknadV10 =
    BarnetrygdSøknadV10(
        kontraktVersjon = 10,
        søker = lagSøkerV10(søkerFnr),
        barn = listOf(lagBarnV8(barnFnr)),
        antallEøsSteg = 0,
        dokumentasjon = emptyList(),
        originalSpråk = "NB",
        finnesPersonMedAdressebeskyttelse = false,
        søknadstype = Søknadstype.ORDINÆR,
        spørsmål = emptyMap(),
        teksterUtenomSpørsmål = emptyMap(),
    )

fun lagBarnetrygdSøknadV9(
    søkerFnr: String,
    barnFnr: String,
): BarnetrygdSøknadV9 =
    BarnetrygdSøknadV9(
        kontraktVersjon = 9,
        søker = lagSøkerV8(søkerFnr),
        barn = listOf(lagBarnV8(barnFnr)),
        antallEøsSteg = 0,
        dokumentasjon = emptyList(),
        originalSpråk = "NB",
        finnesPersonMedAdressebeskyttelse = false,
        søknadstype = Søknadstype.ORDINÆR,
        spørsmål = emptyMap(),
        teksterUtenomSpørsmål = emptyMap(),
    )

fun lagBarnetrygdSøknadV8(
    søkerFnr: String,
    barnFnr: String,
): BarnetrygdSøknadV8 =
    BarnetrygdSøknadV8(
        kontraktVersjon = 8,
        søker = lagSøkerV8(søkerFnr),
        barn = listOf(lagBarnV8(barnFnr)),
        antallEøsSteg = 0,
        dokumentasjon = emptyList(),
        originalSpråk = "NB",
        søknadstype = Søknadstype.ORDINÆR,
        spørsmål = emptyMap(),
        teksterUtenomSpørsmål = emptyMap(),
    )

fun lagBarnetrygdSøknadV7(
    søkerFnr: String,
    barnFnr: String,
): BarnetrygdSøknadV7 =
    BarnetrygdSøknadV7(
        kontraktVersjon = 7,
        søker = lagSøkerV7(søkerFnr),
        barn = listOf(lagBarnV7(barnFnr)),
        antallEøsSteg = 0,
        dokumentasjon = emptyList(),
        originalSpråk = "NB",
        søknadstype = Søknadstype.ORDINÆR,
        spørsmål = emptyMap(),
        teksterUtenomSpørsmål = emptyMap(),
    )

fun <T> lagStringSøknadsfelt(verdi: T): Søknadsfelt<T> =
    Søknadsfelt(
        label = mapOf("no" to ""),
        verdi = mapOf("no" to verdi),
    )

fun lagSøkerV10(fnr: String): SøkerV10 =
    SøkerV10(
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
        utenlandsperioder = emptyList(),
        svalbardOppholdPerioder = emptyList(),
        arbeidsperioderUtland = emptyList(),
        pensjonsperioderUtland = emptyList(),
        arbeidsperioderNorge = emptyList(),
        pensjonsperioderNorge = emptyList(),
        andreUtbetalingsperioder = emptyList(),
        idNummer = emptyList(),
        spørsmål = emptyMap(),
        nåværendeSamboer = null,
        tidligereSamboere = emptyList(),
    )

fun lagSøkerV8(fnr: String): SøkerV8 =
    SøkerV8(
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
        utenlandsperioder = emptyList(),
        arbeidsperioderUtland = emptyList(),
        pensjonsperioderUtland = emptyList(),
        arbeidsperioderNorge = emptyList(),
        pensjonsperioderNorge = emptyList(),
        andreUtbetalingsperioder = emptyList(),
        idNummer = emptyList(),
        spørsmål = emptyMap(),
        nåværendeSamboer = null,
        tidligereSamboere = emptyList(),
    )

fun lagSøkerV7(fnr: String): SøkerV7 =
    SøkerV7(
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
        sivilstand = lagStringSøknadsfelt(SIVILSTANDTYPE.UOPPGITT),
        utenlandsperioder = emptyList(),
        arbeidsperioderUtland = emptyList(),
        pensjonsperioderUtland = emptyList(),
        arbeidsperioderNorge = emptyList(),
        pensjonsperioderNorge = emptyList(),
        andreUtbetalingsperioder = emptyList(),
        idNummer = emptyList(),
        spørsmål = emptyMap(),
        nåværendeSamboer = null,
        tidligereSamboere = emptyList(),
    )

fun lagBarnV8(fnr: String): BarnV8 =
    BarnV8(
        harEøsSteg = false,
        ident = lagStringSøknadsfelt(fnr),
        navn = lagStringSøknadsfelt(""),
        registrertBostedType = lagStringSøknadsfelt(RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
        alder = null,
        andreForelder = null,
        utenlandsperioder = emptyList(),
        omsorgsperson = null,
        idNummer = emptyList(),
        spørsmål = emptyMap(),
        eøsBarnetrygdsperioder = emptyList(),
    )

fun lagBarnV7(fnr: String): BarnV7 =
    BarnV7(
        harEøsSteg = false,
        ident = lagStringSøknadsfelt(fnr),
        navn = lagStringSøknadsfelt(""),
        registrertBostedType = lagStringSøknadsfelt(RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
        alder = lagStringSøknadsfelt("1"),
        andreForelder = null,
        utenlandsperioder = emptyList(),
        omsorgsperson = null,
        idNummer = emptyList(),
        spørsmål = emptyMap(),
        eøsBarnetrygdsperioder = emptyList(),
    )
