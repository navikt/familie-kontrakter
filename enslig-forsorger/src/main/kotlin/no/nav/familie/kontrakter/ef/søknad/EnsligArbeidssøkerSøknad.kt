package no.nav.familie.kontrakter.ef.søknad


data class EnsligArbeidssøkerSøknad(val fødselsnummer: Søknadsfelt<Fødselsnummer>,
                                    val arbeidssøker: Søknadsfelt<Arbeidssøker>)
