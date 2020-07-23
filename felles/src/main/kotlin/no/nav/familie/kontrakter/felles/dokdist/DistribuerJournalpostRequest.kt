package no.nav.familie.kontrakter.felles.dokdist

import javax.validation.constraints.NotBlank

data class DistribuerJournalpostRequest(@field:NotBlank val journalpostId: String,
                                        @field:NotBlank val bestillendeFagsystem: String,
                                        @field:NotBlank val dokumentProdApp: String)
