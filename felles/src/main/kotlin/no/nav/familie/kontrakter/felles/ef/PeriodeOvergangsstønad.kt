package no.nav.familie.kontrakter.felles.ef

import java.time.LocalDate

/**
 * Klasser som brukes for å hente perioder for overgangsstønad fra enslig forsørger (ef-sak)
 */

data class PerioderOvergangsstønadRequest(val personIdent: String,
                                          val fomDato: LocalDate? = null,
                                          val tomDato: LocalDate? = null)

data class PerioderOvergangsstønadResponse(val perioder: List<PeriodeOvergangsstønad>)

data class PeriodeOvergangsstønad(val personIdent: String,
                                  val fomDato: LocalDate,
                                  val tomDato: LocalDate,
                                  val datakilde: Datakilde) {

    enum class Datakilde {
        INFOTRYGD,
        EF
    }
}