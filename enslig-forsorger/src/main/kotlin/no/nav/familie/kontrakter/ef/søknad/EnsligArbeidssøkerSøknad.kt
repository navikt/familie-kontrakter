package no.nav.familie.kontrakter.ef.søknad

import no.nav.familie.kontrakter.felles.Fødselsnummer

data class EnsligArbeidssøkerSøknad(
    val fødselsnummer: Søknadsfelt<Fødselsnummer>,
    val arbeidssøker: Søknadsfelt<Arbeidssøker>,
)
