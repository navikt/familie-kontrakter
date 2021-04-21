package no.nav.familie.kontrakter.felles.dokarkiv.v2

import no.nav.familie.kontrakter.felles.dokarkiv.AvsenderMottaker
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class ArkiverDokumentRequest(@field:NotBlank val fnr: String,
                                  val avsenderMottaker: AvsenderMottaker?,
                                  val forsøkFerdigstill: Boolean,
                                  @field:NotEmpty val hoveddokumentvarianter: List<Dokument>,
                                  val vedleggsdokumenter: List<Dokument> = emptyList(),
                                  val eksternReferanseId: String? = null,
                                  val fagsakId: String? = null,
        //Skal ikke settes for innkommende hvis Ruting gjøres av BRUT001
                                  val journalførendeEnhet: String? = null,
        //Ønsker du å generer forside når du tilskriver bruker kan du fylle ut denne
                                  val førsteside: Førsteside? = null)

