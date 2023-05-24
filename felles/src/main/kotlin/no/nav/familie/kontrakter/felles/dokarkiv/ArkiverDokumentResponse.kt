package no.nav.familie.kontrakter.felles.dokarkiv

import jakarta.validation.constraints.NotBlank

data class ArkiverDokumentResponse(
    @field:NotBlank val journalpostId: String,
    val ferdigstilt: Boolean,
    val dokumenter: List<DokumentInfo>? = null,
)
