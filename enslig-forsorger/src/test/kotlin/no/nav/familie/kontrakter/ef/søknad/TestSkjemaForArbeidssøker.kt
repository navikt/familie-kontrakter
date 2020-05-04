package no.nav.familie.kontrakter.ef.søknad

@Suppress("unused")
internal object TestSkjemaForArbeidssøker {

    // Syntetisk fødselsnummer fra dolly
    @SuppressWarnings
    val skjema = SkjemaForArbeidssøker(Søknadsfelt("Søker", lagPersonaliaForArbeidssøker()),
                                       Testsøknad.lagSøknadsfeltArbeidssøker())

    private fun lagPersonaliaForArbeidssøker(): PersonaliaArbeidssøker {
        return  PersonaliaArbeidssøker(Søknadsfelt("fnr", Fødselsnummer("18068124693")),
                                                  Søknadsfelt("Navn", "Navnesen"))
    }

}

