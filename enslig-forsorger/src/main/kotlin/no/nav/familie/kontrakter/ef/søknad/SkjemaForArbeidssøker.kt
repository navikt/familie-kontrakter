package no.nav.familie.kontrakter.ef.søknad

data class SkjemaForArbeidssøker(
    val personaliaArbeidssøker: Søknadsfelt<PersonaliaArbeidssøker>,
    val arbeidssøker: Søknadsfelt<Arbeidssøker>,
    val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>
)

data class PersonaliaArbeidssøker(
    val fødselsnummer: Søknadsfelt<Fødselsnummer>,
    val navn: Søknadsfelt<String>
)
