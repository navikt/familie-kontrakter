package no.nav.familie.kontrakter.felles.arkivering

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class ArkiverDokumentRequest(@field:NotBlank val fnr: String,
                             @field:NotNull val forsøkFerdigstill: Boolean,
                             @field:NotEmpty val dokumenter: List<Dokument>) {

    val isForsøkFerdigstill = forsøkFerdigstill
}
