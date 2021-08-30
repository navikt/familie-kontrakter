package no.nav.familie.kontrakter.ba.søknad.v3

import no.nav.familie.kontrakter.ba.Søknadstype
import no.nav.familie.kontrakter.ba.søknad.Barn
import no.nav.familie.kontrakter.ba.søknad.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ba.søknad.SøknadAdresse
import no.nav.familie.kontrakter.ba.søknad.Søknaddokumentasjon
import no.nav.familie.kontrakter.ba.søknad.Søknadsfelt
import java.time.LocalDate

enum class Dokumentasjonsbehov {
    AVTALE_DELT_BOSTED,
    VEDTAK_OPPHOLDSTILLATELSE,
    ADOPSJON_DATO,
    BEKREFTELSE_FRA_BARNEVERN,
    BOR_FAST_MED_SØKER,
    ANNEN_DOKUMENTASJON,
    SEPARERT_SKILT_ENKE,
    MEKLINGSATTEST
}

data class Søknad(
    val søknadstype: Søknadstype,
    val søker: Søker,
    val barn: List<Barn>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val dokumentasjon: List<Søknaddokumentasjon>
)

data class NåværendeSamboer(
    val navn: Søknadsfelt<String>,
    val ident: Søknadsfelt<String>,
    val fødselsdato: Søknadsfelt<String>,
    val samboerFraDato: Søknadsfelt<LocalDate>,
)

data class TidligereSamboer(
    val navn: Søknadsfelt<String>,
    val ident: Søknadsfelt<String>,
    val samboerFraDato: Søknadsfelt<LocalDate>,
    val samboerTilDato: Søknadsfelt<LocalDate>,
)

data class Utvidet(
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val nåværendeSamboer: Søknadsfelt<NåværendeSamboer>,
    val tidligereSamboere: List<Søknadsfelt<TidligereSamboer>>
)

data class Søker(
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val statsborgerskap: Søknadsfelt<List<String>>,
    val adresse: Søknadsfelt<SøknadAdresse>,
    val sivilstand: Søknadsfelt<SIVILSTANDTYPE>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val utvidet: Søknadsfelt<Utvidet>?
)