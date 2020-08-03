package no.nav.familie.kontrakter.felles.journalpost

import java.time.LocalDateTime

data class Journalpost(val journalpostId: String,
                       val journalposttype: Journalposttype,
                       val journalstatus: Journalstatus,
                       val tema: String? = null,
                       val behandlingstema: String? = null,
                       val tittel: String? = null,
                       val sak: Sak? = null,
                       val bruker: Bruker? = null,
                       val journalforendeEnhet: String? = null,
                       val kanal: String? = null,
                       val dokumenter: List<DokumentInfo>? = null,
                       val relevanteDatoer: List<RelevantDato>? = null) {

    val datoMottatt = relevanteDatoer?.firstOrNull { it.datotype == "DATO_REGISTRERT" }?.dato
}


data class Sak(val arkivsaksnummer: String? = null,
               var arkivsaksystem: String? = null,
               val fagsakId: String? = null,
               val sakstype: String? = null,
               val fagsaksystem: String? = null)

data class Bruker(val id: String,
                  val type: BrukerIdType)

data class DokumentInfo(val dokumentInfoId: String,
                        val tittel: String?= null,
                        val brevkode: String?= null,
                        val dokumentstatus: Dokumentstatus?= null,
                        val dokumentvarianter: List<Dokumentvariant>?= null,
                        val logiskeVedlegg: List<LogiskVedlegg>?= null)

data class Dokumentvariant(val variantformat: String)
data class LogiskVedlegg(val logiskVedleggId: String, val tittel: String)
data class RelevantDato(val dato: LocalDateTime, val datotype: String)
enum class Journalposttype {
    I,
    U,
    N
}

enum class Journalstatus {
    MOTTATT,
    JOURNALFOERT,
    FERDIGSTILT,
    EKSPEDERT,
    UNDER_ARBEID,
    FEILREGISTRERT,
    UTGAAR,
    AVBRUTT,
    UKJENT_BRUKER,
    RESERVERT,
    OPPLASTING_DOKUMENT,
    UKJENT
}

enum class Dokumentstatus {
    FERDIGSTILT,
    AVBRUTT,
    UNDER_REDIGERING,
    KASSERT
}

enum class BrukerIdType {
    AKTOERID,
    FNR,
    ORGNR
}