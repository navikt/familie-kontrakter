package no.nav.familie.kontrakter.ba.søknad.v7

import no.nav.familie.kontrakter.ba.søknad.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ba.søknad.SøknadAdresse
import no.nav.familie.kontrakter.ba.søknad.v4.Locale
import no.nav.familie.kontrakter.ba.søknad.v4.NåværendeSamboer
import no.nav.familie.kontrakter.ba.søknad.v4.SpørsmålId
import no.nav.familie.kontrakter.ba.søknad.v4.Søknaddokumentasjon
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.v4.TidligereSamboer
import no.nav.familie.kontrakter.ba.søknad.v4.Utenlandsopphold
import no.nav.familie.kontrakter.ba.søknad.v5.RegistrertBostedType
import no.nav.familie.kontrakter.ba.søknad.v6.AndreForelderUtvidet

data class Søknad(
    val kontraktVersjon: Int,
    val antallEøsSteg: Int,
    val søknadstype: Søknadstype,
    val søker: Søker,
    val barn: List<Barn>,
    val spørsmål: Map<SpørsmålId, Søknadsfelt<Any>>,
    val dokumentasjon: List<Søknaddokumentasjon>,
    val teksterUtenomSpørsmål: Map<SpørsmålId, Map<Locale, String>>,
    val originalSpråk: Locale
)

data class Søker(
    val harEøsSteg: Boolean,
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val statsborgerskap: Søknadsfelt<List<String>>,
    val adresse: Søknadsfelt<SøknadAdresse>,
    val sivilstand: Søknadsfelt<SIVILSTANDTYPE>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val nåværendeSamboer: Søknadsfelt<NåværendeSamboer>?,
    val tidligereSamboere: List<Søknadsfelt<TidligereSamboer>>,
    val utenlandsperioder: List<Søknadsfelt<Utenlandsopphold>> = listOf(),
    val andreUtbetalingsperioder: List<Søknadsfelt<Utbetalingsperiode>> = listOf(),
    val arbeidsperioderUtland: List<Søknadsfelt<Arbeidsperiode>> = listOf(),
    val arbeidsperioderNorge: List<Søknadsfelt<Arbeidsperiode>> = listOf(),
    val pensjonsperioderNorge: List<Søknadsfelt<Pensjonsperiode>> = listOf(),
    val pensjonsperioderUtland: List<Søknadsfelt<Pensjonsperiode>> = listOf(),
    val idNummer: List<Søknadsfelt<IdNummer>> = listOf()
)

data class IdNummer(
    val idNummer: Søknadsfelt<String>,
    val land: Søknadsfelt<String>,
)

data class Arbeidsperiode(
    val arbeidsperiodeAvsluttet: Søknadsfelt<String?>,
    val arbeidsperiodeland: Søknadsfelt<String?>,
    val arbeidsgiver: Søknadsfelt<String?>,
    val fraDatoArbeidsperiode: Søknadsfelt<String?>,
    val tilDatoArbeidsperiode: Søknadsfelt<String?>,
)

data class Pensjonsperiode(
    val mottarPensjonNå: Søknadsfelt<String?>,
    val pensjonsland: Søknadsfelt<String?>,
    val pensjonFra: Søknadsfelt<String?>,
    val pensjonTil: Søknadsfelt<String?>,
)

data class Utbetalingsperiode(
    val fårUtbetalingNå: Søknadsfelt<String?>,
    val utbetalingLand: Søknadsfelt<String>,
    val utbetalingFraDato: Søknadsfelt<String>,
    val utbetalingTilDato: Søknadsfelt<String>,
)

data class Barn(
    val harEøsSteg: Boolean,
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val registrertBostedType: Søknadsfelt<RegistrertBostedType>,
    val alder: Søknadsfelt<String>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val utenlandsperioder: List<Søknadsfelt<Utenlandsopphold>> = listOf(),
    val andreForelder: AndreForelder? = null,
    val omsorgsperson: Omsorgsperson? = null,
    val eøsBarnetrygdsperioder: List<Søknadsfelt<EøsBarnetrygdsperiode>> = listOf(),
    val idNummer: List<Søknadsfelt<IdNummer>> = listOf()
)

data class AndreForelder(
    val kanIkkeGiOpplysninger: Boolean,
    val navn: Søknadsfelt<String>,
    val fnr: Søknadsfelt<String>,
    val fødselsdato: Søknadsfelt<String>,
    val arbeidUtlandet: Søknadsfelt<String>,
    val pensjonUtland: Søknadsfelt<String>,
    val skriftligAvtaleOmDeltBosted: Søknadsfelt<String>,
    val utvidet: AndreForelderUtvidet,

    // EØS
    val pensjonNorge: Søknadsfelt<String?>,
    val arbeidNorge: Søknadsfelt<String?>,
    val andreUtbetalinger: Søknadsfelt<String?>,
    val arbeidsperioderUtland: List<Søknadsfelt<Arbeidsperiode>> = listOf(),
    val pensjonsperioderUtland: List<Søknadsfelt<Pensjonsperiode>> = listOf(),
    val arbeidsperioderNorge: List<Søknadsfelt<Arbeidsperiode>> = listOf(),
    val pensjonsperioderNorge: List<Søknadsfelt<Pensjonsperiode>> = listOf(),
    val andreUtbetalingsperioder: List<Søknadsfelt<Utbetalingsperiode>> = listOf(),
    val idNummer: List<Søknadsfelt<IdNummer>> = listOf(),
    val adresse: Søknadsfelt<String>,
)

data class Omsorgsperson(
    val navn: Søknadsfelt<String>,
    val slektsforhold: Søknadsfelt<String>,
    val slektsforholdSpesifisering: Søknadsfelt<String>,
    val idNummer: Søknadsfelt<String>,
    val adresse: Søknadsfelt<String>,
)

data class EøsBarnetrygdsperiode(
    val mottarEøsBarnetrygdNå: Søknadsfelt<String?>,
    val barnetrygdsland: Søknadsfelt<String?>,
    val fraDatoBarnetrygdperiode: Søknadsfelt<String>,
    val tilDatoBarnetrygdperiode: Søknadsfelt<String?>,
    val månedligBeløp: Søknadsfelt<String>,
)
