package no.nav.familie.kontrakter.felles.oppgave

/**
 * Denne request typen er kun for v2 av oppgave-apiet. Den brukes for å oppdatere nøkkelord på en oppgave.
 */
data class OppdaterOppgaveNokkelordRequest(
    val nokkelord: Set<String>,
    val meta: Meta,
) {
    data class Meta(
        val versjon: Int,
    )
}
