package no.nav.familie.kontrakter.felles.dokarkiv

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ArkiverDokumentResponse(@field:NotBlank val journalpostId: String,
                                   val ferdigstilt: Boolean,
                                   val dokumenter: List<DokumentInfo>? = null)
