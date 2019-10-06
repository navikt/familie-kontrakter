package no.nav.familie.ks.oppslag.dokarkiv.api

class ArkiverDokumentResponse(val journalpostId: String, private val ferdigstilt: Boolean?) {
    val isFerdigstilt: Boolean
        get() = ferdigstilt!!
}
