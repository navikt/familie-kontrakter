package no.nav.familie.kontrakter.ks.dokarkiv.api

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.objectMapper
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class ArkiverDokumentRequest(
    @field:NotBlank
    val fnr: String,

    val forsøkFerdigstill: Boolean,

    @field:NotEmpty
    val dokumenter: List<Dokument>
)

fun String.toArkiverDokumentRequest(): ArkiverDokumentRequest = objectMapper.readValue(this)

fun ArkiverDokumentRequest.toJson(): String = objectMapper.writeValueAsString(this)

