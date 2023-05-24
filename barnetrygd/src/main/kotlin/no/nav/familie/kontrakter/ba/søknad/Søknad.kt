package no.nav.familie.kontrakter.ba.søknad

import no.nav.familie.kontrakter.ba.Søknadstype

@Deprecated(
    "Bruk v2",
    ReplaceWith(
        "Søknad",
        "no.nav.familie.kontrakter.ba.søknad.v2.Søknad",
    ),
)
data class Søknad(
    val søknadstype: Søknadstype,
    val søker: Søker,
    val barn: List<Barn>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val dokumentasjon: List<Søknaddokumentasjon>,
)

enum class Dokumentasjonsbehov {
    AVTALE_DELT_BOSTED,
    VEDTAK_OPPHOLDSTILLATELSE,
    ADOPSJON_DATO,
    BEKREFTELSE_FRA_BARNEVERN,
    BOR_FAST_MED_SØKER,
    ANNEN_DOKUMENTASJON,
}

data class Søknaddokumentasjon(
    val dokumentasjonsbehov: Dokumentasjonsbehov,
    val harSendtInn: Boolean,
    val opplastedeVedlegg: List<Søknadsvedlegg>,
)

data class Søknadsvedlegg(
    val dokumentId: String,
    val navn: String,
    val tittel: Dokumentasjonsbehov,
)

data class Søknadsfelt<T>(
    val label: String,
    val verdi: T,
)

data class SøknadAdresse(
    val adressenavn: String?,
    val postnummer: String?,
    val husbokstav: String?,
    val bruksenhetsnummer: String?,
    val husnummer: String?,
    val poststed: String?,
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
    UOPPGITT,
}

@Deprecated(
    "Bruk v2",
    ReplaceWith(
        "Søker",
        "no.nav.familie.kontrakter.ba.søknad.v2.Søker",
    ),
)
data class Søker(
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val statsborgerskap: Søknadsfelt<List<String>>,
    val adresse: Søknadsfelt<SøknadAdresse>,
    val sivilstand: Søknadsfelt<SIVILSTANDTYPE>,
    val telefonnummer: Søknadsfelt<String>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
)

data class Barn(
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val borMedSøker: Søknadsfelt<Boolean>,
    val alder: Søknadsfelt<String>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
)
