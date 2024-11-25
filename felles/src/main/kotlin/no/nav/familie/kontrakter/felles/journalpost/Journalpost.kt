package no.nav.familie.kontrakter.felles.journalpost

import no.nav.familie.kontrakter.felles.Tema

data class Journalpost(
    val journalpostId: String,
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
    val utsendingsinfo: Utsendingsinfo? = null,
) {

    val datoMottatt = relevanteDatoer?.firstOrNull { it.datotype == "DATO_REGISTRERT" }?.dato

    fun erDigitalKanal() = this.kanal == "NAV_NO"

    fun harKontantstøtteSøknad(): Boolean = dokumenter?.any { it.brevkode == "NAV 34-00.08" } ?: false

    fun harBarnetrygdOrdinærSøknad(): Boolean = dokumenter?.any { it.brevkode == "NAV 33-00.07" } ?: false

    fun harBarnetrygdUtvidetSøknad(): Boolean = dokumenter?.any { it.brevkode == "NAV 33-00.09" } ?: false

    fun harBarnetrygdSøknad(): Boolean = harBarnetrygdOrdinærSøknad() || harBarnetrygdUtvidetSøknad()

    fun harDigitalBarnetrygdSøknad() =
        erDigitalKanal() && this.dokumenter?.any { it.erDigitalBarnetrygdSøknad() } ?: false

    fun harDigitalKontantstøtteSøknad() =
        erDigitalKanal() && this.dokumenter?.any { it.erDigitalKontantstøtteSøknad() } ?: false

    fun harDigitalSøknad(tema: Tema): Boolean = when (tema) {
        Tema.BAR -> harDigitalBarnetrygdSøknad()
        Tema.KON -> harDigitalKontantstøtteSøknad()
        else -> throw Error("Støtter ikke tema $tema")
    }

    fun hentHovedDokumentTittel(): String? {
        if (dokumenter.isNullOrEmpty()) error("Journalpost $journalpostId mangler dokumenter")
        return dokumenter.firstOrNull { it.brevkode != null }?.tittel
    }
}
