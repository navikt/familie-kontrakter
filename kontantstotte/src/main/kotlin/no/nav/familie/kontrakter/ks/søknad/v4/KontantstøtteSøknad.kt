package no.nav.familie.kontrakter.ks.søknad.v4

import no.nav.familie.kontrakter.felles.søknad.BaksSøknadBase
import no.nav.familie.kontrakter.felles.søknad.BaksSøknadPersonBase
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt
import no.nav.familie.kontrakter.ks.søknad.v1.BarnehageplassPeriode
import no.nav.familie.kontrakter.ks.søknad.v1.IdNummer
import no.nav.familie.kontrakter.ks.søknad.v1.KontantstøttePeriode
import no.nav.familie.kontrakter.ks.søknad.v1.Locale
import no.nav.familie.kontrakter.ks.søknad.v1.Pensjonsperiode
import no.nav.familie.kontrakter.ks.søknad.v1.RegistrertBostedType
import no.nav.familie.kontrakter.ks.søknad.v1.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ks.søknad.v1.SøknadAdresse
import no.nav.familie.kontrakter.ks.søknad.v1.Søknaddokumentasjon
import no.nav.familie.kontrakter.ks.søknad.v1.TekstPåSpråkMap
import no.nav.familie.kontrakter.ks.søknad.v1.Utbetalingsperiode
import no.nav.familie.kontrakter.ks.søknad.v2.Omsorgsperson

@Deprecated("Bruk v5", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ks.søknad.v5.KontantstøtteSøknad"))
data class KontantstøtteSøknad(
    override val kontraktVersjon: Int,
    override val søker: Søker,
    override val barn: List<Barn>,
    val antallEøsSteg: Int,
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
    val erAvdødPartnerForelder: Søknadsfelt<String>?,
) : BaksSøknadBase

data class Søker(
    val harEøsSteg: Boolean,
    override val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val statsborgerskap: Søknadsfelt<List<String>>,
    val adresse: Søknadsfelt<SøknadAdresse?>,
    val adressebeskyttelse: Boolean,
    val sivilstand: Søknadsfelt<SIVILSTANDTYPE>,
    val borPåRegistrertAdresse: Søknadsfelt<String>?,
    val værtINorgeITolvMåneder: Søknadsfelt<String>,
    val planleggerÅBoINorgeTolvMnd: Søknadsfelt<String>,
    val yrkesaktivFemÅr: Søknadsfelt<String>,
    // Din livssituasjon
    val erAsylsøker: Søknadsfelt<String>,
    val utenlandsoppholdUtenArbeid: Søknadsfelt<String>,
    val utenlandsperioder: List<Søknadsfelt<Utenlandsperiode>> = listOf(),
    val arbeidIUtlandet: Søknadsfelt<String>,
    val arbeidsperioderUtland: List<Søknadsfelt<Arbeidsperiode>>,
    val mottarUtenlandspensjon: Søknadsfelt<String>,
    val pensjonsperioderUtland: List<Søknadsfelt<Pensjonsperiode>>,
    // EØS
    val arbeidINorge: Søknadsfelt<String>?,
    val arbeidsperioderNorge: List<Søknadsfelt<Arbeidsperiode>>,
    val pensjonNorge: Søknadsfelt<String>?,
    val pensjonsperioderNorge: List<Søknadsfelt<Pensjonsperiode>>,
    val andreUtbetalingsperioder: List<Søknadsfelt<Utbetalingsperiode>>,
    val idNummer: List<Søknadsfelt<IdNummer>>,
    val andreUtbetalinger: Søknadsfelt<String>?,
    val adresseISøkeperiode: Søknadsfelt<String>?,
) : BaksSøknadPersonBase

data class Barn(
    val harEøsSteg: Boolean,
    override val ident: Søknadsfelt<String>,
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
    val foreldreBorSammen: Søknadsfelt<String>?,
    val søkerDeltKontantstøtte: Søknadsfelt<String>?,
    val andreForelder: AndreForelder?,
    val utenlandsperioder: List<Søknadsfelt<Utenlandsperiode>> = listOf(),
    // EØS
    val søkersSlektsforhold: Søknadsfelt<String>?,
    val søkersSlektsforholdSpesifisering: Søknadsfelt<String>?,
    val borMedAndreForelder: Søknadsfelt<String>?,
    val borMedOmsorgsperson: Søknadsfelt<String>?,
    val adresse: Søknadsfelt<String>?,
    val omsorgsperson: Omsorgsperson?,
    val idNummer: List<Søknadsfelt<IdNummer>> = listOf(),
) : BaksSøknadPersonBase

data class AndreForelder(
    val kanIkkeGiOpplysninger: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>?,
    val fnr: Søknadsfelt<String>?,
    val fødselsdato: Søknadsfelt<String>?,
    val yrkesaktivFemÅr: Søknadsfelt<String>?,
    val arbeidUtlandet: Søknadsfelt<String>?,
    val arbeidsperioderUtland: List<Søknadsfelt<Arbeidsperiode>> = listOf(),
    val utenlandsoppholdUtenArbeid: Søknadsfelt<String>?,
    val utenlandsperioder: List<Søknadsfelt<Utenlandsperiode>> = listOf(),
    val pensjonUtland: Søknadsfelt<String>?,
    val pensjonsperioderUtland: List<Søknadsfelt<Pensjonsperiode>> = listOf(),
    // EØS
    val idNummer: List<Søknadsfelt<IdNummer>> = listOf(),
    val adresse: Søknadsfelt<String>?,
    val arbeidNorge: Søknadsfelt<String>?,
    val arbeidsperioderNorge: List<Søknadsfelt<Arbeidsperiode>> = listOf(),
    val pensjonNorge: Søknadsfelt<String>?,
    val pensjonsperioderNorge: List<Søknadsfelt<Pensjonsperiode>> = listOf(),
    val andreUtbetalinger: Søknadsfelt<String>?,
    val andreUtbetalingsperioder: List<Søknadsfelt<Utbetalingsperiode>> = listOf(),
    val pågåendeSøknadFraAnnetEøsLand: Søknadsfelt<String>?,
    val pågåendeSøknadHvilketLand: Søknadsfelt<String>?,
    val kontantstøtteFraEøs: Søknadsfelt<String>?,
    val eøsKontantstøttePerioder: List<Søknadsfelt<KontantstøttePeriode>> = listOf(),
)

data class Arbeidsperiode(
    val arbeidsperiodeAvsluttet: Søknadsfelt<String>?,
    val arbeidsperiodeland: Søknadsfelt<String>?,
    val arbeidsgiver: Søknadsfelt<String>,
    val fraDatoArbeidsperiode: Søknadsfelt<String>,
    val tilDatoArbeidsperiode: Søknadsfelt<String>,
    val adresse: Søknadsfelt<String>?,
)

data class Utenlandsperiode(
    val utenlandsoppholdÅrsak: Søknadsfelt<String>,
    val oppholdsland: Søknadsfelt<String>,
    val oppholdslandFraDato: Søknadsfelt<String>?,
    val oppholdslandTilDato: Søknadsfelt<String>?,
    val adresse: Søknadsfelt<String>?,
)
