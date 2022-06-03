package no.nav.familie.kontrakter.ba.søknad.v6

import no.nav.familie.kontrakter.ba.søknad.v4.Locale
import no.nav.familie.kontrakter.ba.søknad.v4.SpørsmålId
import no.nav.familie.kontrakter.ba.søknad.v4.Søker
import no.nav.familie.kontrakter.ba.søknad.v4.Søknaddokumentasjon
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.v4.Utenlandsopphold
import no.nav.familie.kontrakter.ba.søknad.v5.RegistrertBostedType

@Deprecated("Bruk v8", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v8.AndreForelderUtvidet"))
data class AndreForelderUtvidet(
    val søkerHarBoddMedAndreForelder: Søknadsfelt<String>,
    val søkerFlyttetFraAndreForelderDato: Søknadsfelt<String>
)

@Deprecated("Bruk v7", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v7.Søknad"))
data class AndreForelder(
    val navn: Søknadsfelt<String>,
    val fnr: Søknadsfelt<String>,
    val fødselsdato: Søknadsfelt<String>,
    val arbeidUtlandet: Søknadsfelt<String>,
    val arbeidUtlandetHvilketLand: Søknadsfelt<String>,
    val pensjonUtland: Søknadsfelt<String>,
    val pensjonHvilketLand: Søknadsfelt<String>,
    val skriftligAvtaleOmDeltBosted: Søknadsfelt<String>,
    val utvidet: AndreForelderUtvidet,
)

@Deprecated("Bruk v7", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v7.Søknad"))
data class Søknad(
    val søknadstype: Søknadstype,
    val søker: Søker,
    val barn: List<Barn>,
    val spørsmål: Map<SpørsmålId, Søknadsfelt<Any>>,
    val dokumentasjon: List<Søknaddokumentasjon>,
    val teksterUtenomSpørsmål: Map<SpørsmålId, Map<Locale, String>>,
    val originalSpråk: Locale
)

@Deprecated("Bruk v7", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v7.Søknad"))
data class Barn(
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val registrertBostedType: Søknadsfelt<RegistrertBostedType>,
    val alder: Søknadsfelt<String>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val utenlandsperioder: List<Søknadsfelt<Utenlandsopphold>> = listOf(),
    val andreForelder: AndreForelder? = null,
)
