package no.nav.familie.kontrakter.ef.søknad


data class SkjemaForArbeidssøker(val personalia : Søknadsfelt<SkjemaPersonalia>,
                                 val arbeidssøker: Søknadsfelt<Arbeidssøker>)

data class SkjemaPersonalia ( val fødselsnummer: Søknadsfelt<Fødselsnummer>,
                              val navn: Søknadsfelt<String>)
