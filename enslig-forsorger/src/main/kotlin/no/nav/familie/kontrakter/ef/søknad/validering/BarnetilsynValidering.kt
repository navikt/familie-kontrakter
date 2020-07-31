package no.nav.familie.kontrakter.ef.søknad.validering

import no.nav.familie.kontrakter.ef.søknad.BarnetilsynSøknad

object BarnetilsynValidering {

    fun validate(barnetilsynSøknad: BarnetilsynSøknad) {
        requireNotNull(barnetilsynSøknad.aktivitet.verdi.erIArbeid, "aktivitet->erIArbeid")
        barnetilsynSøknad.barn.verdi.forEach {
            requireNotNull(it.skalHaBarnepass, "barn->skalHaBarnepass")
            requireNotNull(it.barnepass, "barn->barnepass")
        }
    }

    private fun requireNotNull(any: Any?, melding: String) {
        requireNotNull(any) { "$melding er obligatorisk i Barnetilsyn" }
    }
}
