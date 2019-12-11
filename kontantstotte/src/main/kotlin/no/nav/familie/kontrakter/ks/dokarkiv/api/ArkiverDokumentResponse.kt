package no.nav.familie.kontrakter.ks.dokarkiv.api

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.objectMapper

class ArkiverDokumentResponse(val journalpostId: String, private val ferdigstilt: Boolean?) {
    val isFerdigstilt: Boolean
        get() = ferdigstilt!!
}

fun String.toArkiverDokumentResponse(): ArkiverDokumentResponse = objectMapper.readValue(this)

fun ArkiverDokumentResponse.toJson(): String = objectMapper.writeValueAsString(this)