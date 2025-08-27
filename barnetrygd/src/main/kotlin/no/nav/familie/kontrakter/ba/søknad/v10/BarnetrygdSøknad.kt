package no.nav.familie.kontrakter.ba.søknad.v10

import no.nav.familie.kontrakter.ba.søknad.v1.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ba.søknad.v1.SøknadAdresse
import no.nav.familie.kontrakter.ba.søknad.v4.Locale
import no.nav.familie.kontrakter.ba.søknad.v4.NåværendeSamboer
import no.nav.familie.kontrakter.ba.søknad.v4.SpørsmålId
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.v4.TidligereSamboer
import no.nav.familie.kontrakter.ba.søknad.v4.Utenlandsopphold
import no.nav.familie.kontrakter.ba.søknad.v5.RegistrertBostedType
import no.nav.familie.kontrakter.ba.søknad.v7.IdNummer
import no.nav.familie.kontrakter.ba.søknad.v7.Søknaddokumentasjon
import no.nav.familie.kontrakter.ba.søknad.v8.AndreForelder
import no.nav.familie.kontrakter.ba.søknad.v8.Arbeidsperiode
import no.nav.familie.kontrakter.ba.søknad.v8.EøsBarnetrygdsperiode
import no.nav.familie.kontrakter.ba.søknad.v8.Omsorgsperson
import no.nav.familie.kontrakter.ba.søknad.v8.Pensjonsperiode
import no.nav.familie.kontrakter.ba.søknad.v8.Utbetalingsperiode
import no.nav.familie.kontrakter.felles.søknad.BaSøknadBase
import no.nav.familie.kontrakter.felles.søknad.BaksSøknadPersonBase
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt as FellesSøknadsfelt

data class BarnetrygdSøknad(
    override val kontraktVersjon: Int,
    override val søker: Søker,
    override val barn: List<Barn>,
    override val dokumentasjon: List<Søknaddokumentasjon>,
    override val søknadstype: Søknadstype,
    val antallEøsSteg: Int,
    val finnesPersonMedAdressebeskyttelse: Boolean,
    val spørsmål: Map<SpørsmålId, Søknadsfelt<Any>>,
    val teksterUtenomSpørsmål: Map<SpørsmålId, Map<Locale, String>>,
    val originalSpråk: Locale,
) : BaSøknadBase

data class Søker(
    override val ident: FellesSøknadsfelt<String>,
    val harEøsSteg: Boolean,
    val navn: FellesSøknadsfelt<String>,
    val statsborgerskap: FellesSøknadsfelt<List<String>>,
    val adresse: FellesSøknadsfelt<SøknadAdresse?>,
    val adressebeskyttelse: Boolean,
    val sivilstand: FellesSøknadsfelt<SIVILSTANDTYPE>,
    val spørsmål: Map<String, FellesSøknadsfelt<Any>>,
    val nåværendeSamboer: FellesSøknadsfelt<NåværendeSamboer>? = null,
    val svalbardOppholdPerioder: List<FellesSøknadsfelt<SvalbardPeriode>> = listOf(),
    val tidligereSamboere: List<FellesSøknadsfelt<TidligereSamboer>> = listOf(),
    val utenlandsperioder: List<FellesSøknadsfelt<Utenlandsopphold>> = listOf(),
    val andreUtbetalingsperioder: List<FellesSøknadsfelt<Utbetalingsperiode>> = listOf(),
    val arbeidsperioderUtland: List<FellesSøknadsfelt<Arbeidsperiode>> = listOf(),
    val arbeidsperioderNorge: List<FellesSøknadsfelt<Arbeidsperiode>> = listOf(),
    val pensjonsperioderNorge: List<FellesSøknadsfelt<Pensjonsperiode>> = listOf(),
    val pensjonsperioderUtland: List<FellesSøknadsfelt<Pensjonsperiode>> = listOf(),
    val idNummer: List<FellesSøknadsfelt<IdNummer>> = listOf(),
) : BaksSøknadPersonBase

data class Barn(
    override val ident: FellesSøknadsfelt<String>,
    val harEøsSteg: Boolean,
    val navn: FellesSøknadsfelt<String>,
    val registrertBostedType: FellesSøknadsfelt<RegistrertBostedType>,
    val alder: FellesSøknadsfelt<String>? = null,
    val spørsmål: Map<String, FellesSøknadsfelt<Any>>,
    val utenlandsperioder: List<FellesSøknadsfelt<Utenlandsopphold>> = listOf(),
    val andreForelder: AndreForelder? = null,
    val omsorgsperson: Omsorgsperson? = null,
    val eøsBarnetrygdsperioder: List<FellesSøknadsfelt<EøsBarnetrygdsperiode>> = listOf(),
    val idNummer: List<FellesSøknadsfelt<IdNummer>> = listOf(),
    val svalbardOppholdPerioder: List<FellesSøknadsfelt<SvalbardPeriode>> = listOf(),
) : BaksSøknadPersonBase

data class SvalbardPeriode(
    val fraDatoSvalbardOpphold: Søknadsfelt<String?>,
    val tilDatoSvalbardOpphold: Søknadsfelt<String?>,
)
