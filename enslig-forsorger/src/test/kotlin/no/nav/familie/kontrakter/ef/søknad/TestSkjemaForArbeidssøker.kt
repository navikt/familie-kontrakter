package no.nav.familie.kontrakter.ef.søknad

@Suppress("unused")
internal object TestSkjemaForArbeidssøker {

    @SuppressWarnings
    val skjema = SkjemaForArbeidssøker(fødselsnummer = Søknadsfelt("fnr", Fødselsnummer("24117938529")),
                                       navn = Søknadsfelt("Navn", "Navnesen"),
                                       arbeidssøker = Testsøknad.lagSøknadsfeltArbeidssøker())

}
