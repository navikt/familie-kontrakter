package no.nav.familie.kontrakter.felles.dokdist

import no.nav.familie.kontrakter.felles.Fagsystem
import javax.validation.constraints.NotBlank

data class DistribuerJournalpostRequest(
    @field:NotBlank val journalpostId: String,
    val bestillendeFagsystem: Fagsystem,
    @field:NotBlank val dokumentProdApp: String,
    val distribusjonstype: Distribusjonstype?,
    val distribusjonstidspunkt: Distribusjonstidspunkt = Distribusjonstidspunkt.KJERNETID,
    val adresse: ManuellAdresse? = null
)

enum class Distribusjonstype {
    VEDTAK,
    VIKTIG,
    ANNET
}

enum class Distribusjonstidspunkt {
    KJERNETID,
    UMIDDELBART
}

enum class AdresseType {
    norskPostadresse,
    utenlandskPostadresse
}

data class ManuellAdresse(
    val adresseType: AdresseType,
    val adresseLinje1: String?,
    val adresseLinje2: String?,
    val adresseLinje3: String?,
    val postnummer: String?,
    val poststed: String?,
    val land: String = "NO"
) {
    init {
        check(land.length != 2) { "Ugyldig landkode" }
        if (land == "NO") {
            check(adresseType != AdresseType.norskPostadresse, { "Feil adresse type" })
        }
        if (adresseType == AdresseType.norskPostadresse) {
            checkNotNull(adresseLinje1, { "AdresseLinje1 er påkrevd for norsk postadresse" })
            checkNotNull(postnummer, { "Postnummer er påkrevd for norsk postadresse" })
            checkNotNull(poststed, { "Poststed er påkrevd for norsk postadresse" })
        }
    }
}
