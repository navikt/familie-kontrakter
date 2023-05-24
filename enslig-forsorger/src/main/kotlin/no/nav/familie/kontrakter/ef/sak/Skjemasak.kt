package no.nav.familie.kontrakter.ef.sak

import no.nav.familie.kontrakter.ef.søknad.SkjemaForArbeidssøker

data class Skjemasak(
    val skjemaForArbeidssøker: SkjemaForArbeidssøker,
    val saksnummer: String,
    val journalpostId: String,
)
