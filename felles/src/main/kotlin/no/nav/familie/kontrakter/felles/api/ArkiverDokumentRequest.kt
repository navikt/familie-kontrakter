package no.nav.familie.kontrakter.felles.api

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class ArkiverDokumentRequest(@field:NotBlank val fnr: String,
                                  val isForsøkFerdigstill: Boolean,
                                  @field:NotEmpty val dokumenter: List<Dokument>)
