package no.nav.familie.kontrakter.felles.arkivering

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class ArkiverDokumentRequest(@field:NotBlank val fnr: String,
                                  @field:NotNull val forsøkFerdigstill: Boolean,
                                  @field:NotEmpty val dokumenter: List<Dokument>,
                                  val fagsakId: String?= null,
                                  val journalførendeEnhet: String? = null) { //Skal ikke settes for innkommende hvis Ruting gjøres av BRUT001
  
    val isForsøkFerdigstill = forsøkFerdigstill
}
