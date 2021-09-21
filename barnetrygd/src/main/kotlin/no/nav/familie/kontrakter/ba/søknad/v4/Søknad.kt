package no.nav.familie.kontrakter.ba.søknad.v4

import no.nav.familie.kontrakter.ba.søknad.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ba.søknad.SøknadAdresse
import java.time.LocalDate

typealias Locale = String
typealias SpørsmålId = String

data class Søknadsfelt<T>(
    val label: Map<Locale, String>,
    val verdi: Map<Locale, T>
)

enum class Søknadstype(val tittel: String, val søknadskode: String) {
    IKKE_SATT("SØKNADSTYPE MANGLER", "SØKNADSTYPE MANGLER"),
    ORDINÆR("Søknad om barnetrygd ordinær", "NAV 33-00.07"),
    UTVIDET("Søknad om utvidet barnetrygd", "NAV 33-00.09"),
}

data class Søknad(
    val søknadstype: Søknadstype,
    val søker: Søker,
    val barn: List<Barn>,
    val spørsmål: Map<SpørsmålId, Søknadsfelt<Any>>,
    val dokumentasjon: List<Søknaddokumentasjon>,
    val teksterUtenomSpørsmål: Map<SpørsmålId, Map<Locale, String>>,
    val originalSpråk: Locale
)

enum class Dokumentasjonsbehov {
    AVTALE_DELT_BOSTED,
    VEDTAK_OPPHOLDSTILLATELSE,
    ADOPSJON_DATO,
    BEKREFTELSE_FRA_BARNEVERN,
    BOR_FAST_MED_SØKER,
    ANNEN_DOKUMENTASJON,
    SEPARERT_SKILT_ENKE,
    MEKLINGSATTEST,
    EØS_SKJEMA,
}

data class Søknadsvedlegg(
    val dokumentId: String,
    val navn: String,
    val tittel: Dokumentasjonsbehov,
)

data class Søknaddokumentasjon(
    val dokumentasjonsbehov: Dokumentasjonsbehov,
    val harSendtInn: Boolean,
    val opplastedeVedlegg: List<Søknadsvedlegg>,
    val dokumentasjonSpråkTittel: Map<Locale, String>
);

data class NåværendeSamboer(
    val navn: Søknadsfelt<String>,
    val ident: Søknadsfelt<String>,
    val fødselsdato: Søknadsfelt<String>,
    val samboerFraDato: Søknadsfelt<LocalDate>,
)

data class TidligereSamboer(
    val navn: Søknadsfelt<String>,
    val ident: Søknadsfelt<String>,
    val fødselsdato: Søknadsfelt<String>,
    val samboerFraDato: Søknadsfelt<LocalDate>,
    val samboerTilDato: Søknadsfelt<LocalDate>,
)

data class Søker(
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val statsborgerskap: Søknadsfelt<List<String>>,
    val adresse: Søknadsfelt<SøknadAdresse>,
    val sivilstand: Søknadsfelt<SIVILSTANDTYPE>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val nåværendeSamboer: Søknadsfelt<NåværendeSamboer>?,
    val tidligereSamboere: List<Søknadsfelt<TidligereSamboer>>
)

data class Barn(
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val borMedSøker: Søknadsfelt<Boolean>,
    val alder: Søknadsfelt<String>,
    val spørsmål: Map<String, Søknadsfelt<Any>>
)
