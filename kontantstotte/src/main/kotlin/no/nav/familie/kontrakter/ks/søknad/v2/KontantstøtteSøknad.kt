package no.nav.familie.kontrakter.ks.søknad.v2

import no.nav.familie.kontrakter.ks.søknad.v1.BarnehageplassPeriode
import no.nav.familie.kontrakter.ks.søknad.v1.EøsKontantstøttePeriode
import no.nav.familie.kontrakter.ks.søknad.v1.IdNummer
import no.nav.familie.kontrakter.ks.søknad.v1.KontantstøttePeriode
import no.nav.familie.kontrakter.ks.søknad.v1.Locale
import no.nav.familie.kontrakter.ks.søknad.v1.Pensjonsperiode
import no.nav.familie.kontrakter.ks.søknad.v1.RegistrertBostedType
import no.nav.familie.kontrakter.ks.søknad.v1.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ks.søknad.v1.SøknadAdresse
import no.nav.familie.kontrakter.ks.søknad.v1.Søknaddokumentasjon
import no.nav.familie.kontrakter.ks.søknad.v1.Søknadsfelt
import no.nav.familie.kontrakter.ks.søknad.v1.TekstPåSpråkMap
import no.nav.familie.kontrakter.ks.søknad.v1.Utbetalingsperiode
import no.nav.familie.kontrakter.ks.søknad.v1.Utenlandsopphold
import no.nav.familie.kontrakter.ks.søknad.v1.Utenlandsperiode

@Deprecated("Bruk v3", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ks.søknad.v3.KontantstøtteSøknad"))
data class KontantstøtteSøknad(
    val kontraktVersjon: Int,
    val antallEøsSteg: Int,
    val søker: Søker,
    val barn: List<Barn>,
    val dokumentasjon: List<Søknaddokumentasjon>,
    val teksterTilPdf: Map<String, TekstPåSpråkMap>,
    val originalSpråk: Locale,
    val erNoenAvBarnaFosterbarn: Søknadsfelt<String>,
    val søktAsylForBarn: Søknadsfelt<String>,
    val oppholderBarnSegIInstitusjon: Søknadsfelt<String>,
    val barnOppholdtSegTolvMndSammenhengendeINorge: Søknadsfelt<String>,
    val erBarnAdoptert: Søknadsfelt<String>,
    val mottarKontantstøtteForBarnFraAnnetEøsland: Søknadsfelt<String>,
    val harEllerTildeltBarnehageplass: Søknadsfelt<String>,
    val erAvdødPartnerForelder: Søknadsfelt<String>?
)

data class Søker(
    val harEøsSteg: Boolean,
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val statsborgerskap: Søknadsfelt<List<String>>,
    val adresse: Søknadsfelt<SøknadAdresse?>,
    val adressebeskyttelse: Boolean,
    val sivilstand: Søknadsfelt<SIVILSTANDTYPE>,
    val borPåRegistrertAdresse: Søknadsfelt<String>?,
    val værtINorgeITolvMåneder: Søknadsfelt<String>,
    val utenlandsperioder: List<Søknadsfelt<Utenlandsperiode>>,
    val planleggerÅBoINorgeTolvMnd: Søknadsfelt<String>?,
    val yrkesaktivFemÅr: Søknadsfelt<String>,

    // Din livssituasjon
    val erAsylsøker: Søknadsfelt<String>,
    val arbeidIUtlandet: Søknadsfelt<String>,
    val mottarUtenlandspensjon: Søknadsfelt<String>,
    val arbeidsperioderUtland: List<Søknadsfelt<Arbeidsperiode>>,
    val pensjonsperioderUtland: List<Søknadsfelt<Pensjonsperiode>>,

    // EØS
    val arbeidINorge: Søknadsfelt<String>?,
    val arbeidsperioderNorge: List<Søknadsfelt<Arbeidsperiode>>,
    val pensjonNorge: Søknadsfelt<String>?,
    val pensjonsperioderNorge: List<Søknadsfelt<Pensjonsperiode>>,
    val andreUtbetalingsperioder: List<Søknadsfelt<Utbetalingsperiode>>,
    val idNummer: List<Søknadsfelt<IdNummer>>,
    val andreUtbetalinger: Søknadsfelt<String>?,
    val adresseISøkeperiode: Søknadsfelt<String>?
)

@Deprecated("Bruk v3", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ks.søknad.v3.Barn"))
data class Barn(
    val harEøsSteg: Boolean,
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val registrertBostedType: Søknadsfelt<RegistrertBostedType>,
    val alder: Søknadsfelt<String>?,
    val teksterTilPdf: Map<String, TekstPåSpråkMap>,

    // Om Barna
    val erFosterbarn: Søknadsfelt<String>,
    val oppholderSegIInstitusjon: Søknadsfelt<String>,
    val erAdoptert: Søknadsfelt<String>,
    val erAsylsøker: Søknadsfelt<String>,
    val boddMindreEnn12MndINorge: Søknadsfelt<String>,
    val kontantstøtteFraAnnetEøsland: Søknadsfelt<String>,
    val harBarnehageplass: Søknadsfelt<String>,
    val andreForelderErDød: Søknadsfelt<String>?,

    // Om barnet - oppfølgningsspørsmål fra "om barna"
    val utbetaltForeldrepengerEllerEngangsstønad: Søknadsfelt<String>?,
    val mottarEllerMottokEøsKontantstøtte: Søknadsfelt<String>?,
    val pågåendeSøknadFraAnnetEøsLand: Søknadsfelt<String>?,
    val pågåendeSøknadHvilketLand: Søknadsfelt<String>?,
    val planleggerÅBoINorge12Mnd: Søknadsfelt<String>?,
    val eøsKontantstøttePerioder: List<Søknadsfelt<KontantstøttePeriode>> = listOf(),
    val barnehageplassPerioder: List<Søknadsfelt<BarnehageplassPeriode>> = listOf(),

    // Om barnet
    val borFastMedSøker: Søknadsfelt<String>,
    val andreForelder: AndreForelder?,
    val utenlandsperioder: List<Søknadsfelt<Utenlandsopphold>> = listOf(),

    // EØS
    val søkersSlektsforhold: Søknadsfelt<String>?,
    val søkersSlektsforholdSpesifisering: Søknadsfelt<String>?,
    val borMedAndreForelder: Søknadsfelt<String>?,
    val borMedOmsorgsperson: Søknadsfelt<String>?,
    val adresse: Søknadsfelt<String>?,
    val omsorgsperson: Omsorgsperson?,
    val idNummer: List<Søknadsfelt<IdNummer>> = listOf()
)

data class Omsorgsperson(
    val navn: Søknadsfelt<String>,
    val slektsforhold: Søknadsfelt<String>?,
    val slektsforholdSpesifisering: Søknadsfelt<String>?,
    val idNummer: Søknadsfelt<String>,
    val adresse: Søknadsfelt<String>,
    val arbeidUtland: Søknadsfelt<String>,
    val arbeidsperioderUtland: List<Søknadsfelt<Arbeidsperiode>> = listOf(),
    val arbeidNorge: Søknadsfelt<String>,
    val arbeidsperioderNorge: List<Søknadsfelt<Arbeidsperiode>> = listOf(),
    val pensjonUtland: Søknadsfelt<String>,
    val pensjonsperioderUtland: List<Søknadsfelt<Pensjonsperiode>> = listOf(),
    val pensjonNorge: Søknadsfelt<String>,
    val pensjonsperioderNorge: List<Søknadsfelt<Pensjonsperiode>> = listOf(),
    val andreUtbetalinger: Søknadsfelt<String>,
    val andreUtbetalingsperioder: List<Søknadsfelt<Utbetalingsperiode>> = listOf(),
    val pågåendeSøknadFraAnnetEøsLand: Søknadsfelt<String>,
    val pågåendeSøknadHvilketLand: Søknadsfelt<String>?,
    val kontantstøtteFraEøs: Søknadsfelt<String>,
    val eøsKontantstøttePerioder: List<Søknadsfelt<EøsKontantstøttePeriode>> = listOf()
)

data class AndreForelder(
    val kanIkkeGiOpplysninger: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>?,
    val fnr: Søknadsfelt<String>?,
    val fødselsdato: Søknadsfelt<String>?,
    val yrkesaktivFemÅr: Søknadsfelt<String>?,
    val pensjonUtland: Søknadsfelt<String>?,
    val arbeidUtlandet: Søknadsfelt<String>?,
    val skriftligAvtaleOmDeltBosted: Søknadsfelt<String>?,

    // EØS
    val pensjonNorge: Søknadsfelt<String>?,
    val arbeidNorge: Søknadsfelt<String>?,
    val andreUtbetalinger: Søknadsfelt<String>?,
    val kontantstøtteFraEøs: Søknadsfelt<String>?,
    val arbeidsperioderUtland: List<Søknadsfelt<Arbeidsperiode>> = listOf(),
    val pensjonsperioderUtland: List<Søknadsfelt<Pensjonsperiode>> = listOf(),
    val arbeidsperioderNorge: List<Søknadsfelt<Arbeidsperiode>> = listOf(),
    val pensjonsperioderNorge: List<Søknadsfelt<Pensjonsperiode>> = listOf(),
    val pågåendeSøknadFraAnnetEøsLand: Søknadsfelt<String>?,
    val pågåendeSøknadHvilketLand: Søknadsfelt<String>?,
    val eøsKontantstøttePerioder: List<Søknadsfelt<KontantstøttePeriode>> = listOf(),
    val andreUtbetalingsperioder: List<Søknadsfelt<Utbetalingsperiode>> = listOf(),
    val idNummer: List<Søknadsfelt<IdNummer>> = listOf(),
    val adresse: Søknadsfelt<String>?
)

data class Arbeidsperiode(
    val arbeidsperiodeAvsluttet: Søknadsfelt<String>?,
    val arbeidsperiodeland: Søknadsfelt<String>?,
    val arbeidsgiver: Søknadsfelt<String>?,
    val fraDatoArbeidsperiode: Søknadsfelt<String>?,
    val tilDatoArbeidsperiode: Søknadsfelt<String>?,
    val adresse: Søknadsfelt<String>?
)
