package no.nav.familie.ks.kontrakter.dokarkiv.api

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.ks.kontrakter.Kontrakt
import no.nav.familie.ks.kontrakter.objectMapper

class ArkiverDokumentResponse(val journalpostId: String, private val ferdigstilt: Boolean?) : Kontrakt {
    val isFerdigstilt: Boolean
        get() = ferdigstilt!!
}

fun String.toArkiverDokumentResponse(): ArkiverDokumentResponse = objectMapper.readValue(this)

fun ArkiverDokumentResponse.toJson(): String = objectMapper.writeValueAsString(this)