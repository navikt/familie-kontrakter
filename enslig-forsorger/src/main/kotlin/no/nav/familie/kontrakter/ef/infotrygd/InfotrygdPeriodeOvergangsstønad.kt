package no.nav.familie.kontrakter.ef.infotrygd

import java.time.LocalDate

/**
 * @param personIdenter alle identer til personen
 */
data class InfotrygdPerioderOvergangsstønadRequest(val personIdenter: Set<String>,
                                                   val fomDato: LocalDate? = null,
                                                   val tomDato: LocalDate? = null)

data class InfotrygdPerioderOvergangsstønadResponse(val perioder: List<InfotrygdPeriodeOvergangsstønad>)

data class InfotrygdPeriodeOvergangsstønad(val personIdent: String,
                                           val fomDato: LocalDate,
                                           val tomDato: LocalDate,
                                           val beløp: Float)