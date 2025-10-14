package no.nav.familie.kontrakter.felles.personopplysning

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Bostedsadresse(
    val gyldigFraOgMed: LocalDate? = null,
    val gyldigTilOgMed: LocalDate? = null,
    val angittFlyttedato: LocalDate? = null,
    val vegadresse: Vegadresse? = null,
    val matrikkeladresse: Matrikkeladresse? = null,
    val ukjentBosted: UkjentBosted? = null,
)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Oppholdsadresse(
    val gyldigFraOgMed: LocalDate? = null,
    val gyldigTilOgMed: LocalDate? = null,
    val oppholdAnnetSted: String? = null,
    val vegadresse: Vegadresse? = null,
    val matrikkeladresse: Matrikkeladresse? = null,
    val utenlandskAdresse: UtenlandskAdresse? = null,
    val folkeregistermetadata: Folkeregistermetadata? = null,
)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class DeltBosted(
    val startdatoForKontrakt: LocalDate? = null,
    val sluttdatoForKontrakt: LocalDate? = null,
    val vegadresse: Vegadresse? = null,
    val matrikkeladresse: Matrikkeladresse? = null,
    val ukjentBosted: UkjentBosted? = null,
)

data class Vegadresse(
    val matrikkelId: Long?,
    val husnummer: String?,
    val husbokstav: String?,
    val bruksenhetsnummer: String?,
    val adressenavn: String?,
    val kommunenummer: String?,
    val tilleggsnavn: String?,
    val postnummer: String?,
)

data class Folkeregistermetadata(
    val opphoerstidspunkt: LocalDate?,
    val kilde: String?,
)

data class UkjentBosted(
    val bostedskommune: String,
)

data class Matrikkeladresse(
    val matrikkelId: Long?,
    val bruksenhetsnummer: String?,
    val tilleggsnavn: String?,
    val postnummer: String?,
    val kommunenummer: String?,
)

data class UtenlandskAdresse(
    val adressenavnNummer: String?,
    val bygningEtasjeLeilighet: String?,
    val postboksNummerNavn: String?,
    val postkode: String?,
    val bySted: String?,
    val regionDistriktOmraade: String?,
    val landkode: String,
)

data class Statsborgerskap(
    val land: String,
    val gyldigFraOgMed: LocalDate?,
    val gyldigTilOgMed: LocalDate?,
    val bekreftelsesdato: LocalDate?,
)

data class Sivilstand(
    val type: SIVILSTANDTYPE,
    val gyldigFraOgMed: LocalDate? = null,
)

data class Opphold(
    val type: OPPHOLDSTILLATELSE,
    val oppholdFra: LocalDate?,
    val oppholdTil: LocalDate?,
)

data class ForelderBarnRelasjon(
    val relatertPersonsIdent: String?,
    val relatertPersonsRolle: FORELDERBARNRELASJONROLLE,
)

data class Adressebeskyttelse(
    val gradering: ADRESSEBESKYTTELSEGRADERING,
)

enum class OPPHOLDSTILLATELSE {
    MIDLERTIDIG,
    PERMANENT,
    OPPLYSNING_MANGLER,
}

enum class SIVILSTANDTYPE {
    UOPPGITT,
    UGIFT,
    GIFT,
    ENKE_ELLER_ENKEMANN,
    SKILT,
    SEPARERT,
    REGISTRERT_PARTNER,
    SEPARERT_PARTNER,
    SKILT_PARTNER,
    GJENLEVENDE_PARTNER,
}

enum class FORELDERBARNRELASJONROLLE {
    BARN,
    FAR,
    MEDMOR,
    MOR,
    DOEDFOEDT_BARN,
}

enum class ADRESSEBESKYTTELSEGRADERING {
    STRENGT_FORTROLIG_UTLAND, // Kode 19
    FORTROLIG, // Kode 7
    STRENGT_FORTROLIG, // Kode 6
    UGRADERT,
}

enum class KJOENN {
    MANN,
    KVINNE,
    UKJENT,
}

enum class OppholdAnnetSted(
    val kode: String,
) {
    MILITAER("militaer"),
    PENDLER("pendler"),
    UTENRIKS("utenriks"),
    PAA_SVALBARD("paaSvalbard"),
    ;

    override fun toString(): String =
        when (this) {
            MILITAER -> "militær"
            PENDLER -> "pendler"
            UTENRIKS -> "utenriks"
            PAA_SVALBARD -> "Svalbard"
        }

    companion object {
        fun parse(verdi: String?): OppholdAnnetSted? = entries.firstOrNull { it.kode == verdi || it.name == verdi }
    }
}
