package no.nav.familie.kontrakter.felles.arkivering

import javax.validation.constraints.NotBlank

class ArkiverDokumentResponse(@field:NotBlank val journalpostId: String,
                              @field:NotBlank val ferdigstilt: Boolean)
