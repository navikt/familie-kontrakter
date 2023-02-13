package no.nav.familie.kontrakter.felles.arkivering

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import no.nav.familie.kontrakter.felles.dokarkiv.Dokument

@Deprecated(
    "Bruk arkiverDokumentV3",
    replaceWith = ReplaceWith("no.nav.familie.kontrakter.felles.dokarkiv.ArkiverDokumentRequest")
)
data class ArkiverDokumentRequest(
    @field:NotBlank val fnr: String,
    val forsøkFerdigstill: Boolean,
    @field:NotEmpty val dokumenter: List<Dokument>,
    val fagsakId: String? = null,
    // Skal ikke settes for innkommende hvis Ruting gjøres av BRUT001
    val journalførendeEnhet: String? = null
)
