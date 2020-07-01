package no.nav.familie.kontrakter.felles.personinfo

import java.time.LocalDate

data class Bostedsadresse(
        val vegadresse: Vegadresse? = null,
        val matrikkeladresse: Matrikkeladresse? = null,
        val ukjentBosted: UkjentBosted? = null
)

data class Vegadresse(
        val matrikkelId: Long?,
        val husnummer: String?,
        val husbokstav: String?,
        val bruksenhetsnummer: String?,
        val adressenavn: String?,
        val kommunenummer: String?,
        val tilleggsnavn: String?,
        val postnummer: String?
)

data class UkjentBosted(
        val bostedskommune: String
)

data class Matrikkeladresse(
        val matrikkelId: Long?,
        val bruksenhetsnummer: String?,
        val tilleggsnavn: String?,
        val postnummer: String?,
        val kommunenummer: String?
)

data class Statsborgerskap(val land: String,
                           val gyldigFraOgMed: LocalDate?,
                           val gyldigTilOgMed: LocalDate?)


enum class SIVILSTAND {
    UOPPGITT,
    UGIFT,
    GIFT,
    ENKE_ELLER_ENKEMANN,
    SKILT,
    SEPARERT,
    REGISTRERT_PARTNER,
    SEPARERT_PARTNER,
    SKILT_PARTNER,
    GJENLEVENDE_PARTNER
}
