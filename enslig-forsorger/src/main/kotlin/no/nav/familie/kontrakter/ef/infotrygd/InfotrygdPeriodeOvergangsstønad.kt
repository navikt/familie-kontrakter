package no.nav.familie.kontrakter.ef.infotrygd

import java.time.LocalDate

data class InfotrygdPerioderOvergangsstønadRequest(val identer: Set<String>,
                                                   val fomDato: LocalDate? = null,
                                                   val tomDato: LocalDate? = null)

data class InfotrygdPerioderOvergangsstønadResponse(val perioder: List<InfotrygdPeriodeOvergangsstønad>)

data class InfotrygdPeriodeOvergangsstønad(val ident: String,
                                           val fomDato: LocalDate,
                                           val tomDato: LocalDate,
                                           val beløp: Float)