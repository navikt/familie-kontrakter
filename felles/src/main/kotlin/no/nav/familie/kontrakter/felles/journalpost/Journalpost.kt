package no.nav.familie.kontrakter.felles.journalpost

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Journalpost(val journalpostId: String,
                       val journalposttype: Journalposttype,
                       val journalstatus: Journalstatus,
                       val tema: String?,
                       val behandlingstema: String?,
                       val tittel: String?,
                       val sak: Sak?,
                       val bruker: Bruker?,
                       @JsonProperty("journalforendeEnhet")
                       val journalførendeEnhet: String?,
                       val kanal: String?,
                       val dokumenter: List<DokumentInfo>?,
                       val relevanteDatoer: List<RelevantDato>?) {

    val datoMottatt = relevanteDatoer?.firstOrNull { it.datotype == "DATO_REGISTRERT" }?.dato
}


data class Sak(val arkivsaksnummer: String?,
               var arkivsaksystem: String?,
               val fagsakId: String?,
               val sakstype: String?,
               val fagsaksystem: String?)

data class Bruker(val id: String,
                  val type: BrukerIdType)

data class DokumentInfo(val dokumentInfoId: String,
                        val tittel: String?,
                        val brevkode: String?,
                        val dokumentstatus: Dokumentstatus?,
                        val dokumentvarianter: List<Dokumentvariant>?,
                        val logiskeVedlegg: List<LogiskVedlegg>?
)

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