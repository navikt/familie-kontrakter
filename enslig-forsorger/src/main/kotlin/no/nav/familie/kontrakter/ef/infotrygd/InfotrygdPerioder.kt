package no.nav.familie.kontrakter.ef.infotrygd

import java.time.LocalDate

/**
 * @param personIdenter alle identer til personen
 */
data class InfotrygdPerioderArenaRequest(val personIdenter: Set<String>,
                                         val fomDato: LocalDate? = null,
                                         val tomDato: LocalDate? = null)

data class InfotrygdPerioderResponse(val perioder: List<InfotrygdPeriode>)

data class InfotrygdPeriode(val personIdent: String,
                            val fomDato: LocalDate,
                            val tomDato: LocalDate,
                            val beløp: Float,
                            val opphørsdato: LocalDate? = null)