package no.nav.familie.kontrakter.felles.organisasjon

data class Organisasjon(
    val organisasjonsnummer: String,
    val navn: String,
    val adresse: OrganisasjonAdresse? = null,
)

// https://github.com/navikt/ereg-services/blob/main/src/main/java/no/nav/ereg/provider/rs/organisasjon/contract/Adresse.java
data class OrganisasjonAdresse(
    val type: String,
    val kommunenummer: String?,
)
