package no.nav.familie.kontrakter.felles.oppdrag

/**
 * Perioder er idn for perioder, eks 1,2,3
 */
data class PerioderForBehandling(val behandlingId: String,
                                 val perioder: Set<Long>,
                                 val aktivFødselsnummer: String)
