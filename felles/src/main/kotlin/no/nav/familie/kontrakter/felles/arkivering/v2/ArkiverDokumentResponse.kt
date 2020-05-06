package no.nav.familie.kontrakter.felles.arkivering.v2

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ArkiverDokumentResponse(@field:NotBlank val journalpostId: String,
                                   @field:NotNull val ferdigstilt: Boolean)
