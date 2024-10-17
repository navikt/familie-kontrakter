package no.nav.familie.kontrakter.ba.søknad.v7

import no.nav.familie.kontrakter.ba.søknad.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ba.søknad.SøknadAdresse
import no.nav.familie.kontrakter.ba.søknad.v4.Locale
import no.nav.familie.kontrakter.ba.søknad.v4.NåværendeSamboer
import no.nav.familie.kontrakter.ba.søknad.v4.SpørsmålId
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.v4.TidligereSamboer
import no.nav.familie.kontrakter.ba.søknad.v4.Utenlandsopphold
import no.nav.familie.kontrakter.ba.søknad.v5.RegistrertBostedType
import no.nav.familie.kontrakter.ba.søknad.v6.AndreForelderUtvidet
import no.nav.familie.kontrakter.felles.søknad.BaksSøknadBase
import no.nav.familie.kontrakter.felles.søknad.BaksSøknadPersonBase
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt

@Deprecated("Bruk v8", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v8.Søknad"))
data class Søknad(
    override val kontraktVersjon: Int,
    override val søker: Søker,
    override val barn: List<Barn>,
    val antallEøsSteg: Int,
    val søknadstype: Søknadstype,
    val spørsmål: Map<SpørsmålId, Søknadsfelt<Any>>,
    val dokumentasjon: List<Søknaddokumentasjon>,
    val teksterUtenomSpørsmål: Map<SpørsmålId, Map<Locale, String>>,
    val originalSpråk: Locale,
) : BaksSøknadBase

data class Søknaddokumentasjon(
    val dokumentasjonsbehov: Dokumentasjonsbehov,
    val harSendtInn: Boolean,
    val opplastedeVedlegg: List<Søknadsvedlegg>,
    val dokumentasjonSpråkTittel: Map<Locale, String>,
)

enum class Dokumentasjonsbehov {
    AVTALE_DELT_BOSTED,
    VEDTAK_OPPHOLDSTILLATELSE,
    ADOPSJON_DATO,
    BEKREFTELSE_FRA_BARNEVERN,
    BOR_FAST_MED_SØKER,
    SEPARERT_SKILT_ENKE,
    MEKLINGSATTEST,
    ANNEN_DOKUMENTASJON,
}

data class Søknadsvedlegg(
    val dokumentId: String,
    val navn: String,
    val tittel: Dokumentasjonsbehov,
)

@Deprecated("Bruk v8", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v8.Søker"))
data class Søker(
    override val ident: Søknadsfelt<String>,
    val harEøsSteg: Boolean,
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
    val idNummer: List<Søknadsfelt<IdNummer>> = listOf(),
) : BaksSøknadPersonBase

data class IdNummer(
    val idNummer: Søknadsfelt<String>,
    val land: Søknadsfelt<String>,
)

@Deprecated("Bruk v8", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v8.Arbeidsperiode"))
data class Arbeidsperiode(
    val arbeidsperiodeAvsluttet: Søknadsfelt<String?>,
    val arbeidsperiodeland: Søknadsfelt<String?>,
    val arbeidsgiver: Søknadsfelt<String?>,
    val fraDatoArbeidsperiode: Søknadsfelt<String?>,
    val tilDatoArbeidsperiode: Søknadsfelt<String?>,
)

@Deprecated("Bruk v8", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v8.Pensjonsperiode"))
data class Pensjonsperiode(
    val mottarPensjonNå: Søknadsfelt<String?>,
    val pensjonsland: Søknadsfelt<String?>,
    val pensjonFra: Søknadsfelt<String?>,
    val pensjonTil: Søknadsfelt<String?>,
)

@Deprecated("Bruk v8", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v8.Utbetalingsperiode"))
data class Utbetalingsperiode(
    val fårUtbetalingNå: Søknadsfelt<String?>,
    val utbetalingLand: Søknadsfelt<String>,
    val utbetalingFraDato: Søknadsfelt<String>,
    val utbetalingTilDato: Søknadsfelt<String>,
)

@Deprecated("Bruk v8", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v8.Barn"))
data class Barn(
    override val ident: Søknadsfelt<String>,
    val harEøsSteg: Boolean,
    val navn: Søknadsfelt<String>,
    val registrertBostedType: Søknadsfelt<RegistrertBostedType>,
    val alder: Søknadsfelt<String>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val utenlandsperioder: List<Søknadsfelt<Utenlandsopphold>> = listOf(),
    val andreForelder: AndreForelder? = null,
    val omsorgsperson: Omsorgsperson? = null,
    val eøsBarnetrygdsperioder: List<Søknadsfelt<EøsBarnetrygdsperiode>> = listOf(),
    val idNummer: List<Søknadsfelt<IdNummer>> = listOf(),
) : BaksSøknadPersonBase

@Deprecated("Bruk v8", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v8.AndreForelder"))
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

@Deprecated("Bruk v8", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v8.Omsorgsperson"))
data class Omsorgsperson(
    val navn: Søknadsfelt<String>,
    val slektsforhold: Søknadsfelt<String>,
    val slektsforholdSpesifisering: Søknadsfelt<String>,
    val idNummer: Søknadsfelt<String>,
    val adresse: Søknadsfelt<String>,
)

@Deprecated("Bruk v8", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v8.EøsBarnetrygdsperiode"))
data class EøsBarnetrygdsperiode(
    val mottarEøsBarnetrygdNå: Søknadsfelt<String?>,
    val barnetrygdsland: Søknadsfelt<String?>,
    val fraDatoBarnetrygdperiode: Søknadsfelt<String>,
    val tilDatoBarnetrygdperiode: Søknadsfelt<String?>,
    val månedligBeløp: Søknadsfelt<String>,
)
