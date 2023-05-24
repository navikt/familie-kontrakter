package no.nav.familie.kontrakter.felles.journalpost

data class Sak(
    val arkivsaksnummer: String? = null,
    var arkivsaksystem: String? = null,
    val fagsakId: String? = null,
    val sakstype: String? = null,
    val fagsaksystem: String? = null,
)
