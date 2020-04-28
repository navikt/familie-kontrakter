package no.nav.familie.kontrakter.ef.søknad

@Suppress("unused")
internal object TestSkjemaForArbeidssøker {

    // Syntetisk fødselsnummer fra dolly
    @SuppressWarnings
    val skjema = SkjemaForArbeidssøker(fødselsnummer = Søknadsfelt("fnr", Fødselsnummer("18068124693")),
                                       navn = Søknadsfelt("Navn", "Navnesen"),
                                       arbeidssøker = Testsøknad.lagSøknadsfeltArbeidssøker())

}
