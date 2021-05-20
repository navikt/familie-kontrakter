package no.nav.familie.kontrakter.felles.personopplysning

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDate

data class Bostedsadresse(val gyldigFraOgMed: LocalDate?,
                          val gyldigTilOgMed: LocalDate?,
                          val vegadresse: Vegadresse? = null,
                          val matrikkeladresse: Matrikkeladresse? = null,
                          val ukjentBosted: UkjentBosted? = null)

data class Vegadresse(val matrikkelId: Long?,
                      val husnummer: String?,
                      val husbokstav: String?,
                      val bruksenhetsnummer: String?,
                      val adressenavn: String?,
                      val kommunenummer: String?,
                      val tilleggsnavn: String?,
                      val postnummer: String?)

data class UkjentBosted(val bostedskommune: String
)

data class Matrikkeladresse(val matrikkelId: Long?,
                            val bruksenhetsnummer: String?,
                            val tilleggsnavn: String?,
                            val postnummer: String?,
                            val kommunenummer: String?)

data class Statsborgerskap(val land: String,
                           val gyldigFraOgMed: LocalDate?,
                           val gyldigTilOgMed: LocalDate?)

data class Sivilstand(
        val type: SIVILSTAND,
        val gyldigFraOgMed: LocalDate?
)

data class Opphold(val type: OPPHOLDSTILLATELSE,
                   val oppholdFra: LocalDate?,
                   val oppholdTil: LocalDate?)

enum class OPPHOLDSTILLATELSE {
    MIDLERTIDIG,
    PERMANENT,
    OPPLYSNING_MANGLER
}

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
