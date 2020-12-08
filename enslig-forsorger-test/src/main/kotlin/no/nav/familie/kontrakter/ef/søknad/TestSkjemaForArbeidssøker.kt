import no.nav.familie.kontrakter.ef.søknad.*
import no.nav.familie.util.FnrGenerator

object TestSkjemaForArbeidssøker {

    val testSøknad = TestSøknadBuilder.Builder().build()

    @SuppressWarnings
    val skjema = SkjemaForArbeidssøker(Søknadsfelt("Søker", lagPersonaliaForArbeidssøker()),
            testSøknad.aktivitet.arbeidssøker!!,
            Søknadsfelt("Innsendingsdetaljer", testSøknad.innsendingsdetaljer))

    private fun lagPersonaliaForArbeidssøker(): PersonaliaArbeidssøker {
        return  PersonaliaArbeidssøker(Søknadsfelt("fnr", Fødselsnummer(FnrGenerator.generer())),
                Søknadsfelt("Navn", "Navnesen"))
    }

}
