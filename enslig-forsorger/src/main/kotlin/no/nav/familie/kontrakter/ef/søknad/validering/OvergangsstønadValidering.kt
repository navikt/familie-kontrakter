package no.nav.familie.kontrakter.ef.søknad.validering

import no.nav.familie.kontrakter.ef.søknad.OvergangsstønadSøknad

object OvergangsstønadValidering {

    fun validate(søknad: OvergangsstønadSøknad) {
        søknad.aktivitet.verdi.aksjeselskap?.verdi?.forEach {
            requireNotNull(it.arbeidsmengde, "aktivitet->aksjeselskap->arbeidsmengdea")
        }
        søknad.aktivitet.verdi.arbeidsforhold?.verdi?.forEach {
            requireNotNull(it.arbeidsmengde, "aktivitet->arbeidsforhold->arbeidsmengde")
        }
        requireNotNull(søknad.aktivitet.verdi.selvstendig?.verdi?.arbeidsmengde, "aktivitet->selvstendig->arbeidsmengde")
    }

    private fun requireNotNull(any: Any?, melding: String) {
        requireNotNull(any) { "$melding er obligatorisk i Overgangsstønad" }
    }
}
