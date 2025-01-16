package no.nav.familie.kontrakter.ef.søknad

import no.nav.familie.kontrakter.felles.Fødselsnummer

data class SkjemaForArbeidssøker(
    val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>,
    val personaliaArbeidssøker: Søknadsfelt<PersonaliaArbeidssøker>,
    val arbeidssøker: Søknadsfelt<Arbeidssøker>,
)

data class PersonaliaArbeidssøker(
    val fødselsnummer: Søknadsfelt<Fødselsnummer>,
    val navn: Søknadsfelt<String>,
)
