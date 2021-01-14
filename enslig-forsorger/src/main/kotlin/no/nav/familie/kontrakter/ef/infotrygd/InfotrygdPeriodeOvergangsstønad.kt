package no.nav.familie.kontrakter.ef.infotrygd

import java.time.LocalDate

data class InfotrygdPerioderOvergangsstønadRequest(val personIdenter: Set<String>,
                                                   val fomDato: LocalDate? = null,
                                                   val tomDato: LocalDate? = null)

data class InfotrygdPerioderOvergangsstønadResponse(val perioder: List<InfotrygdPeriodeOvergangsstønad>)

data class InfotrygdPeriodeOvergangsstønad(val personIdent: String,
                                           val fomDato: LocalDate,
                                           val tomDato: LocalDate,
                                           val beløp: Float)