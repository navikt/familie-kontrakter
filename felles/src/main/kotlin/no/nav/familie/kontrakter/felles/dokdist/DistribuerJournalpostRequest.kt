package no.nav.familie.kontrakter.felles.dokdist

import no.nav.familie.kontrakter.felles.Fagsystem
import javax.validation.constraints.NotBlank

data class DistribuerJournalpostRequest(@field:NotBlank val journalpostId: String,
                                        val bestillendeFagsystem: Fagsystem,
                                        @field:NotBlank val dokumentProdApp: String)
