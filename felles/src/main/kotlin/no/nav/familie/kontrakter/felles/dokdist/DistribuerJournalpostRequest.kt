package no.nav.familie.kontrakter.felles.dokdist

import no.nav.familie.kontrakter.felles.Fagsystem
import javax.validation.constraints.NotBlank

data class DistribuerJournalpostRequest(
    @field:NotBlank val journalpostId: String,
    val bestillendeFagsystem: Fagsystem,
    @field:NotBlank val dokumentProdApp: String,
    val distribusjonstype: Distribusjonstype?,
    val distribusjonstidspunkt: Distribusjonstidspunkt = Distribusjonstidspunkt.KJERNETID,
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
