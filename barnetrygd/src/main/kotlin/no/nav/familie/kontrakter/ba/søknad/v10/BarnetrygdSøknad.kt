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
import no.nav.familie.kontrakter.ba.søknad.v7.IdNummer
import no.nav.familie.kontrakter.ba.søknad.v7.Søknaddokumentasjon
import no.nav.familie.kontrakter.ba.søknad.v8.Arbeidsperiode
import no.nav.familie.kontrakter.ba.søknad.v8.Barn
import no.nav.familie.kontrakter.ba.søknad.v8.Pensjonsperiode
import no.nav.familie.kontrakter.ba.søknad.v8.Utbetalingsperiode
import no.nav.familie.kontrakter.felles.søknad.BaksSøknadBase
import no.nav.familie.kontrakter.felles.søknad.BaksSøknadPersonBase
import java.time.LocalDate
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt as FellesSøknadsfelt

data class BarnetrygdSøknad(
    override val kontraktVersjon: Int,
    override val søker: Søker,
    override val barn: List<Barn>,
    val antallEøsSteg: Int,
    val søknadstype: Søknadstype,
    val finnesPersonMedAdressebeskyttelse: Boolean,
    val spørsmål: Map<SpørsmålId, Søknadsfelt<Any>>,
    val dokumentasjon: List<Søknaddokumentasjon>,
    val teksterUtenomSpørsmål: Map<SpørsmålId, Map<Locale, String>>,
    val originalSpråk: Locale,
) : BaksSøknadBase

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

data class SvalbardPeriode(
    val fraDatoSvalbardOpphold: Søknadsfelt<String?>,
    val tilDatoSvalbardOpphold: Søknadsfelt<String?>,
)