package no.nav.familie.kontrakter.ef.søknad

import no.nav.familie.util.FnrGenerator

@Suppress("unused")
internal object TestSkjemaForArbeidssøker {

    // Syntetisk fødselsnummer fra dolly
    @SuppressWarnings
    val skjema = SkjemaForArbeidssøker(Søknadsfelt("Søker", lagPersonaliaForArbeidssøker()),
                                       Testsøknad.lagSøknadsfeltArbeidssøker(),
                                        Søknadsfelt("Innsendingsdetaljer", Testsøknad.innsendingsdetaljer()))

    private fun lagPersonaliaForArbeidssøker(): PersonaliaArbeidssøker {
        return  PersonaliaArbeidssøker(Søknadsfelt("fnr", Fødselsnummer(FnrGenerator.generer())),
                                       Søknadsfelt("Navn", "Navnesen"))
    }

}

