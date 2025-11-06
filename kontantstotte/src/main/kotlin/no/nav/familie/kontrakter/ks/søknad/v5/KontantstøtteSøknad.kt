package no.nav.familie.kontrakter.ks.søknad.v5

import no.nav.familie.kontrakter.felles.søknad.BaksSøknadBase
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt
import no.nav.familie.kontrakter.ks.søknad.v1.Locale
import no.nav.familie.kontrakter.ks.søknad.v1.Søknaddokumentasjon
import no.nav.familie.kontrakter.ks.søknad.v1.TekstPåSpråkMap
import no.nav.familie.kontrakter.ks.søknad.v4.Barn
import no.nav.familie.kontrakter.ks.søknad.v4.Søker

@Deprecated("Bruk v6", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ks.søknad.v6.KontantstøtteSøknad"))
data class KontantstøtteSøknad(
    override val kontraktVersjon: Int,
    override val søker: Søker,
    override val barn: List<Barn>,
    val antallEøsSteg: Int,
    val dokumentasjon: List<Søknaddokumentasjon>,
    val teksterTilPdf: Map<String, TekstPåSpråkMap>,
    val originalSpråk: Locale,
    val finnesPersonMedAdressebeskyttelse: Boolean,
    val erNoenAvBarnaFosterbarn: Søknadsfelt<String>,
    val søktAsylForBarn: Søknadsfelt<String>,
    val oppholderBarnSegIInstitusjon: Søknadsfelt<String>,
    val barnOppholdtSegTolvMndSammenhengendeINorge: Søknadsfelt<String>,
    val erBarnAdoptert: Søknadsfelt<String>,
    val mottarKontantstøtteForBarnFraAnnetEøsland: Søknadsfelt<String>,
    val harEllerTildeltBarnehageplass: Søknadsfelt<String>,
    val erAvdødPartnerForelder: Søknadsfelt<String>?,
) : BaksSøknadBase
