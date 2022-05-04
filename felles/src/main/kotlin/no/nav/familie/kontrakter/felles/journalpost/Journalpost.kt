package no.nav.familie.kontrakter.felles.journalpost

data class Journalpost(val journalpostId: String,
                       val journalposttype: Journalposttype,
                       val journalstatus: Journalstatus,
                       val tema: String? = null,
                       val behandlingstema: String? = null,
                       val tittel: String? = null,
                       val sak: Sak? = null,
                       val bruker: Bruker? = null,
                       val avsenderMottaker: AvsenderMottaker? = null,
                       val journalforendeEnhet: String? = null,
                       val kanal: String? = null,
                       val dokumenter: List<DokumentInfo>? = null,
                       val relevanteDatoer: List<RelevantDato>? = null,
                       val eksternReferanseId: String? = null,
) {

    val datoMottatt = relevanteDatoer?.firstOrNull { it.datotype == "DATO_REGISTRERT" }?.dato
}
