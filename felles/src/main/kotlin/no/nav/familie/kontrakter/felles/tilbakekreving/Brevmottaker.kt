package no.nav.familie.kontrakter.felles.tilbakekreving

import javax.validation.Valid
import javax.validation.constraints.Pattern

data class Brevmottaker(
    val type: MottakerType,
    @field:Pattern(regexp = "^(.{1,80})\$", message = "Feltet kan ikke være tomt eller innholde mer enn 80 tegn")
    val navn: String,
    @field:Valid
    val manuellAdresseInfo: ManuellAdresseInfo
)

enum class MottakerType(val visningsnavn: String) {
    BRUKER_MED_UTENLANDSK_ADRESSE("Bruker med utenlandsk adresse"),
    FULLMEKTIG("Fullmektig"),
    DØDSBO("Dødsbo")
}

data class ManuellAdresseInfo(
    @field:Pattern(regexp = "^(.{1,80})\$", message = "Feltet kan ikke være tomt eller innholde mer enn 80 tegn")
    val adresselinje1: String,
    @field:Pattern(regexp = "^(.{0,80})\$", message = "Feltet kan ikke inneholde mer enn 80 tegn")
    val adresselinje2: String? = null,
    @field:Pattern(regexp = "^(.{1,10})\$", message = "Feltet kan ikke være tomt eller innholde mer enn 10 tegn")
    val postnummer: String,
    @field:Pattern(regexp = "^(.{1,50})\$", message = "Feltet kan ikke være tomt eller innholde mer enn 50 tegn")
    val poststed: String,
    @field:Pattern(regexp = "^[a-zA-Z]{2}$", message = "Landkode må følge ISO standard, alpha-2")
    val landkode: String
)
