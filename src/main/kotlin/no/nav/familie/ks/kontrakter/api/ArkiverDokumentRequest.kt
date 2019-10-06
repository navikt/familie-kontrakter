package no.nav.familie.ks.oppslag.dokarkiv.api

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.ks.kontrakter.Kontrakt
import no.nav.familie.ks.kontrakter.objectMapper
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class ArkiverDokumentRequest(
    @field:NotBlank
    val fnr: String,

    @field:NotBlank
    val navn: String,

    val forsøkFerdigstill: Boolean,

    @field:NotEmpty
    val dokumenter: List<Dokument>
) : Kontrakt

fun String.toArkiverDokumentRequest(): ArkiverDokumentRequest = objectMapper.readValue(this)

fun ArkiverDokumentRequest.toJson(): String = objectMapper.writeValueAsString(this)

