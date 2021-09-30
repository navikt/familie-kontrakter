package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.ef.felles.StønadType
import java.time.LocalDate

/**
 * @param personIdenter alle identer til personen
 */
data class InfotrygdPerioderArenaRequest(val personIdenter: Set<String>,
                                         val fomDato: LocalDate? = null,
                                         val tomDato: LocalDate? = null)

data class InfotrygdPerioderArenaResponse(val perioder: List<InfotrygdArenaPeriode>)

data class InfotrygdArenaPeriode(val personIdent: String,
                                 val fomDato: LocalDate,
                                 val tomDato: LocalDate,
                                 val beløp: Float,
                                 val opphørsdato: LocalDate? = null)

data class InfotrygdPeriodeRequest(val personIdenter: Set<String>,
                                   val stønadstyper: Set<StønadType>)

data class InfotrygdPeriodeResponse(val perioder: List<InfotrygdPeriode>)

data class InfotrygdPeriode(val personIdent: String,
                            val kode: String,
                            val brukerId: String,
                            val stønadId: Long,
                            val vedtakId: Long,
                            val stønadBeløp: Int,
                            val inntektsreduksjon: Int,
                            val samordningsfradrag: Int,
                            val beløp: Int,
                            val startDato: LocalDate,
                            val stønadFom: LocalDate,
                            val stønadTom: LocalDate,
                            val opphørsdato: LocalDate?)