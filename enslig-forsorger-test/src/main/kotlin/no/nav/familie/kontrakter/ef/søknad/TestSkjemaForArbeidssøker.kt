package no.nav.familie.kontrakter.ef.søknad

import no.nav.familie.util.FnrGenerator

object TestSkjemaForArbeidssøker {

    val testsøknad = TestsøknadBuilder.Builder().build()

    @SuppressWarnings
    val skjema = SkjemaForArbeidssøker(
        Søknadsfelt("Søker", lagPersonaliaForArbeidssøker()),
        testsøknad.aktivitet.arbeidssøker!!,
        Søknadsfelt("Innsendingsdetaljer", testsøknad.innsendingsdetaljer)
    )

    private fun lagPersonaliaForArbeidssøker(): PersonaliaArbeidssøker {
        return PersonaliaArbeidssøker(
            Søknadsfelt("fnr", Fødselsnummer(FnrGenerator.generer())),
            Søknadsfelt("Navn", "Navnesen")
        )
    }
}
