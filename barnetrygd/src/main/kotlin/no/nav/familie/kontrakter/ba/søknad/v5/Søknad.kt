package no.nav.familie.kontrakter.ba.søknad.v5

import no.nav.familie.kontrakter.ba.søknad.v4.Locale
import no.nav.familie.kontrakter.ba.søknad.v4.SpørsmålId
import no.nav.familie.kontrakter.ba.søknad.v4.Søker
import no.nav.familie.kontrakter.ba.søknad.v4.Søknaddokumentasjon
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.v4.Utenlandsopphold

@Deprecated("Bruk v6", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v6.Søknad"))
data class Søknad(
    val søknadstype: Søknadstype,
    val søker: Søker,
    val barn: List<Barn>,
    val spørsmål: Map<SpørsmålId, Søknadsfelt<Any>>,
    val dokumentasjon: List<Søknaddokumentasjon>,
    val teksterUtenomSpørsmål: Map<SpørsmålId, Map<Locale, String>>,
    val originalSpråk: Locale
)

enum class RegistrertBostedType {
    REGISTRERT_SOKERS_ADRESSE,
    REGISTRERT_ANNEN_ADRESSE,
    ADRESSESPERRE,
    IKKE_FYLT_INN,
}

@Deprecated("Bruk v6", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v6.Barn"))
data class Barn(
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val registrertBostedType: Søknadsfelt<RegistrertBostedType>,
    val alder: Søknadsfelt<String>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val utenlandsperioder: List<Søknadsfelt<Utenlandsopphold>> = listOf()
)
