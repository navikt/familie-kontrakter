package no.nav.familie.kontrakter.felles.arkivering

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

class ArkiverDokumentRequest(@field:NotBlank val fnr: String,
                             @field:NotBlank val forsøkFerdigstill: Boolean,
                             @field:NotEmpty val dokumenter: List<Dokument>) {

    val isForsøkFerdigstill = forsøkFerdigstill
}
