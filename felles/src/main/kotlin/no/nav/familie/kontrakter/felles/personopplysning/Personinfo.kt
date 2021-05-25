package no.nav.familie.kontrakter.felles.personopplysning

import java.time.LocalDate

data class Bostedsadresse(val gyldigFraOgMed: LocalDate? = null,
                          val gyldigTilOgMed: LocalDate? = null,
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
        val gyldigFraOgMed: LocalDate? = null,
)

data class Opphold(val type: OPPHOLDSTILLATELSE,
                   val oppholdFra: LocalDate?,
                   val oppholdTil: LocalDate?)

data class ForelderBarnRelasjon(val relatertPersonsIdent: String,
                                val relatertPersonsRolle: FORELDERBARNRELASJONROLLE)

data class Adressebeskyttelse(
        val gradering: ADRESSEBESKYTTELSEGRADERING
)

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

enum class FORELDERBARNRELASJONROLLE {
    BARN,
    FAR,
    MEDMOR,
    MOR
}

enum class ADRESSEBESKYTTELSEGRADERING {
    STRENGT_FORTROLIG_UTLAND, // Kode 19
    FORTROLIG, // Kode 7
    STRENGT_FORTROLIG, // Kode 6
    UGRADERT
}

enum class KJOENN {
    MANN,
    KVINNE,
    UKJENT
}
