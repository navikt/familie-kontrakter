package no.nav.familie.kontrakter.ef.søknad

import no.nav.familie.kontrakter.felles.Fødselsnummer

object TestSkjemaForArbeidssøker {
    val testsøknad = TestsøknadBuilder.Builder().build()

    @SuppressWarnings
    val skjema =
        SkjemaForArbeidssøker(
            Søknadsfelt("Innsendingsdetaljer", testsøknad.innsendingsdetaljer),
            Søknadsfelt("Søker", lagPersonaliaForArbeidssøker()),
            testsøknad.aktivitet.arbeidssøker!!,
        )

    private fun lagPersonaliaForArbeidssøker(): PersonaliaArbeidssøker =
        PersonaliaArbeidssøker(
            Søknadsfelt("fnr", Fødselsnummer(Testsøknad.syntetiskFnr)),
            Søknadsfelt("Navn", "Navnesen"),
        )
}
