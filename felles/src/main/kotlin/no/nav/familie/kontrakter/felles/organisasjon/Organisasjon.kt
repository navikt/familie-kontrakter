package no.nav.familie.kontrakter.felles.organisasjon

import java.time.LocalDate

data class Organisasjon(
    val organisasjonsnummer: String,
    val navn: String,
    val adresse: OrganisasjonAdresse? = null,
)

// https://github.com/navikt/ereg-services/blob/main/src/main/java/no/nav/ereg/provider/rs/organisasjon/contract/Adresse.java
data class OrganisasjonAdresse(
    val type: String,
    val adresselinje1: String?,
    val adresselinje2: String?,
    val adresselinje3: String?,
    val postnummer: String,
    val kommunenummer: String,
    val gyldighetsperiode: Gyldighetsperiode?,
)

data class Gyldighetsperiode(
    val fom: LocalDate,
    val tom: LocalDate?,
)
