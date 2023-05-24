package no.nav.familie.kontrakter.ef.søknad

import no.nav.familie.kontrakter.felles.Fødselsnummer

object TestSkjemaForArbeidssøker {

    val testsøknad = TestsøknadBuilder.Builder().build()

    @SuppressWarnings
    val skjema = SkjemaForArbeidssøker(
        Søknadsfelt("Søker", lagPersonaliaForArbeidssøker()),
        testsøknad.aktivitet.arbeidssøker!!,
        Søknadsfelt("Innsendingsdetaljer", testsøknad.innsendingsdetaljer),
    )

    private fun lagPersonaliaForArbeidssøker(): PersonaliaArbeidssøker {
        return PersonaliaArbeidssøker(
            Søknadsfelt("fnr", Fødselsnummer(Testsøknad.syntetiskFnr)),
            Søknadsfelt("Navn", "Navnesen"),
        )
    }
}
