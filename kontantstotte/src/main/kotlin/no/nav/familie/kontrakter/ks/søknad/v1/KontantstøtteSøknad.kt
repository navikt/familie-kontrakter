package no.nav.familie.kontrakter.ks.søknad.v1

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

typealias Locale = String
data class Søknadsfelt<T>(
    val label: Map<Locale, String>,
    val verdi: Map<Locale, T>
)

class TekstPåSpråkMap(tekstPåSpråk: Map<Locale, String>) : HashMap<Locale, String>(tekstPåSpråk)

enum class Dokumentasjonsbehov {
    AVTALE_DELT_BOSTED,
    VEDTAK_OPPHOLDSTILLATELSE,
    ADOPSJON_DATO,
    BEKREFTELSE_FRA_BARNEVERN,
    BOR_FAST_MED_SØKER,
    ANNEN_DOKUMENTASJON,
    BEKREFTELESE_PÅ_BARNEHAGEPLASS
}

data class Søknadsvedlegg(
    val dokumentId: String,
    val navn: String,
    val tittel: Dokumentasjonsbehov
)

data class Søknaddokumentasjon(
    val dokumentasjonsbehov: Dokumentasjonsbehov,
    val harSendtInn: Boolean,
    val opplastedeVedlegg: List<Søknadsvedlegg>,
    val dokumentasjonSpråkTittel: Map<Locale, String>
)

data class SøknadAdresse(
    val adressenavn: String?,
    val postnummer: String?,
    val husbokstav: String?,
    val bruksenhetsnummer: String?,
    val husnummer: String?,
    val poststed: String?
)

data class IdNummer(
    val idNummer: Søknadsfelt<String>,
    val land: Søknadsfelt<String>
)

enum class SIVILSTANDTYPE {
    GIFT,
    ENKE_ELLER_ENKEMANN,
    SKILT,
    SEPARERT,
    REGISTRERT_PARTNER,
    SEPARERT_PARTNER,
    SKILT_PARTNER,
    GJENLEVENDE_PARTNER,
    UGIFT,
    UOPPGITT
}

enum class RegistrertBostedType {
    REGISTRERT_SOKERS_ADRESSE,
    REGISTRERT_ANNEN_ADRESSE,
    ADRESSESPERRE,
    IKKE_FYLT_INN
}

data class Utenlandsopphold(
    val utenlandsoppholdÅrsak: Søknadsfelt<String>,
    val oppholdsland: Søknadsfelt<String>,
    val oppholdslandTilDato: Søknadsfelt<String?>,
    val oppholdslandFraDato: Søknadsfelt<String?>
)

data class Omsorgsperson(
    val navn: Søknadsfelt<String>,
    val slektsforhold: Søknadsfelt<String>,
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

data class EøsKontantstøttePeriode(
    val mottarEøsKontantstøtteNå: Søknadsfelt<String>?,
    val kontantstøtteLand: Søknadsfelt<String>,
    val fraDatoKontantstøttePeriode: Søknadsfelt<String>,
    val tilDatoKontantstøttePeriode: Søknadsfelt<String>?,
    val månedligBeløp: Søknadsfelt<String>
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
    val tilDatoArbeidsperiode: Søknadsfelt<String>?
)

data class Pensjonsperiode(
    val mottarPensjonNå: Søknadsfelt<String>?,
    val pensjonsland: Søknadsfelt<String>?,
    val pensjonFra: Søknadsfelt<String>?,
    val pensjonTil: Søknadsfelt<String>?
)

data class Utbetalingsperiode(
    val fårUtbetalingNå: Søknadsfelt<String>?,
    val utbetalingLand: Søknadsfelt<String>,
    val utbetalingFraDato: Søknadsfelt<String>,
    val utbetalingTilDato: Søknadsfelt<String>
)

data class Utenlandsperiode(
    val utenlandsoppholdÅrsak: Søknadsfelt<String>,
    val oppholdsland: Søknadsfelt<String>,
    val oppholdslandFraDato: Søknadsfelt<String?>,
    val oppholdslandTilDato: Søknadsfelt<String?>
)

data class KontantstøttePeriode(
    val mottarEøsKontantstøtteNå: Søknadsfelt<String>?,
    val kontantstøtteLand: Søknadsfelt<String>,
    val fraDatoKontantstøttePeriode: Søknadsfelt<String>,
    val tilDatoKontantstøttePeriode: Søknadsfelt<String>?,
    val månedligBeløp: Søknadsfelt<String>
)

data class BarnehageplassPeriode(
    val barnehageplassPeriodeBeskrivelse: Søknadsfelt<String>,
    val barnehageplassUtlandet: Søknadsfelt<String>,
    val barnehageplassLand: Søknadsfelt<String>?,
    val offentligStøtte: Søknadsfelt<String>?,
    val antallTimer: Søknadsfelt<String>,
    val startetIBarnehagen: Søknadsfelt<String>,
    val slutterIBarnehagen: Søknadsfelt<String>
)
