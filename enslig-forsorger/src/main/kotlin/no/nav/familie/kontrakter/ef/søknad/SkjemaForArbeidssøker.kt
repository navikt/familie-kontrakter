package no.nav.familie.kontrakter.ef.søknad


data class SkjemaForArbeidssøker(val fødselsnummer: Søknadsfelt<Fødselsnummer>,
                                 val arbeidssøker: Søknadsfelt<Arbeidssøker>)
