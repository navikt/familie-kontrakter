package no.nav.familie.kontrakter.felles.arkivering.v2

import no.nav.familie.kontrakter.felles.arkivering.Dokument
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class ArkiverDokumentRequest(@field:NotBlank val fnr: String,
                                  val forsøkFerdigstill: Boolean,
                                  @field:NotEmpty val hoveddokumentvarianter: List<Dokument>,
                                  val vedleggsdokumenter: List<Dokument> = emptyList(),
                                  val fagsakId: String? = null,
        //Skal ikke settes for innkommende hvis Ruting gjøres av BRUT001
                                  val journalførendeEnhet: String? = null)

