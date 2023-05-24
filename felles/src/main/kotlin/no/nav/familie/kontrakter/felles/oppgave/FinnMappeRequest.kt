package no.nav.familie.kontrakter.felles.oppgave

data class FinnMappeRequest(
    val tema: List<String>? = null,
    val enhetsnr: String,
    val opprettetFom: String? = null,
    val limit: Int = 1000,
)
