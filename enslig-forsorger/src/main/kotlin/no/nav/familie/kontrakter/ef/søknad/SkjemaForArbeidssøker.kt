package no.nav.familie.kontrakter.ef.søknad


data class SkjemaForArbeidssøker(val fødselsnummer: Søknadsfelt<Fødselsnummer>,
                                 val navn: Søknadsfelt<String>,
                                 val arbeidssøker: Søknadsfelt<Arbeidssøker>)
