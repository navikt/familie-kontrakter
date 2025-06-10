package no.nav.familie.kontrakter.ba.søknad.v9

import no.nav.familie.kontrakter.ba.søknad.v4.Locale
import no.nav.familie.kontrakter.ba.søknad.v4.SpørsmålId
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.v7.Søknaddokumentasjon
import no.nav.familie.kontrakter.ba.søknad.v8.Barn
import no.nav.familie.kontrakter.ba.søknad.v8.Søker
import no.nav.familie.kontrakter.felles.søknad.BaksSøknadBase
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

@JvmName("hentVerdiForV4Søknadsfelt")
fun Map<String, Søknadsfelt<Any>>.hentVerdiForSøknadsfelt(søknadsFeltId: SøknadsFeltId): Any? {
    return this[søknadsFeltId.verdiIKontrakt]?.bokmålsverdi()
}

@JvmName("hentVerdiForFellesSøknadsfelt")
fun Map<String, FellesSøknadsfelt<Any>>.hentVerdiForSøknadsfelt(søknadsFeltId: SøknadsFeltId): Any? {
    return this[søknadsFeltId.verdiIKontrakt]?.bokmålsverdi()
}

fun <T> Søknadsfelt<T>.bokmålsverdi(): T? {
    return this.verdi["nb"]
}

fun <T> FellesSøknadsfelt<T>.bokmålsverdi(): T? {
    return this.verdi["nb"]
}

fun Any?.tilBoolskSvar(): Boolean = this is String && this.equals("JA", ignoreCase = true)

