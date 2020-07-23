package no.nav.familie.kontrakter.felles.arkivering

import no.nav.familie.kontrakter.felles.dokarkiv.Dokument
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Deprecated("Bruk arkiverDokumentV3",
            replaceWith = ReplaceWith("no.nav.familie.kontrakter.felles.dokarkiv.ArkiverDokumentRequest"))
data class ArkiverDokumentRequest(@field:NotBlank val fnr: String,
                                  val forsøkFerdigstill: Boolean,
                                  @field:NotEmpty val dokumenter: List<Dokument>,
                                  val fagsakId: String? = null,
        //Skal ikke settes for innkommende hvis Ruting gjøres av BRUT001
                                  val journalførendeEnhet: String? = null)

