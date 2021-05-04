package no.nav.familie.kontrakter.ba.søknad

import no.nav.familie.kontrakter.ba.Søknadstype

data class Søknad(
        val søknadstype: Søknadstype,
        val søker: Søker,
        val barn: List<Barn>,
        val spørsmål: Map<String, Søknadsfelt<Any>>,
        val vedleggReferanser: Map<String, Søknadsfelt<String>>
)

data class Søknadsfelt<T>(
        val label: String,
        val verdi: T
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
        UOPPGITT
}

data class Søker(
        val ident: Søknadsfelt<String>,
        val navn: Søknadsfelt<String>,
        val statsborgerskap: Søknadsfelt<List<String>>,
        val adresse: Søknadsfelt<SøknadAdresse>,
        val sivilstand: Søknadsfelt<SIVILSTANDTYPE>,
        val telefonnummer: Søknadsfelt<String>,
        val spørsmål: Map<String, Søknadsfelt<Any>>
)

data class Barn(
        val ident: Søknadsfelt<String>,
        val navn: Søknadsfelt<String>,
        val borMedSøker: Søknadsfelt<Boolean>,
        val alder: Søknadsfelt<String>,
        val spørsmål: Map<String, Søknadsfelt<Any>>
)
