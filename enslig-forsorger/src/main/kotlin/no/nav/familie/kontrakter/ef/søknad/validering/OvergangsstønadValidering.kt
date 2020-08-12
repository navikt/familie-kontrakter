package no.nav.familie.kontrakter.ef.søknad.validering

import no.nav.familie.kontrakter.ef.søknad.SøknadOvergangsstønad

object OvergangsstønadValidering {

    fun validate(søknad: SøknadOvergangsstønad) {
        søknad.aktivitet.verdi.aksjeselskap?.verdi?.forEach {
            requireNotNull(it.arbeidsmengde, "aktivitet->aksjeselskap->arbeidsmengdea")
        }
        søknad.aktivitet.verdi.arbeidsforhold?.verdi?.forEach {
            requireNotNull(it.arbeidsmengde, "aktivitet->arbeidsforhold->arbeidsmengde")
        }
        søknad.aktivitet.verdi.selvstendig?.verdi?.let {
            requireNotNull(it.arbeidsmengde, "aktivitet->selvstendig->arbeidsmengde")
        }
        søknad.aktivitet.verdi.firmaer?.verdi?.forEach {
            requireNotNull(it.arbeidsmengde, "aktivitet->firma->arbeidsmengde")
        }
    }

    private fun requireNotNull(any: Any?, melding: String) {
        requireNotNull(any) { "$melding er obligatorisk i Overgangsstønad" }
    }
}
