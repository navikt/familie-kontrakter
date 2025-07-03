package no.nav.familie.kontrakter.ef.søknad.validering

import no.nav.familie.kontrakter.ef.søknad.SøknadBarnetilsyn

object BarnetilsynValidering {
    fun validate(søknad: SøknadBarnetilsyn) {
        requireNotNull(søknad.aktivitet.verdi.erIArbeid, "aktivitet->erIArbeid")
        søknad.barn.verdi.forEach {
            requireNotNull(it.skalHaBarnepass, "barn->skalHaBarnepass")
            if (it.skalHaBarnepass!!.verdi) {
                requireNotNull(it.barnepass, "barn->barnepass")
                requireNotNull(it.annenForelder, "barn->annenForelder")
            }
        }
    }

    private fun requireNotNull(
        any: Any?,
        melding: String,
    ) {
        requireNotNull(any) { "$melding er obligatorisk i Barnetilsyn" }
    }
}
