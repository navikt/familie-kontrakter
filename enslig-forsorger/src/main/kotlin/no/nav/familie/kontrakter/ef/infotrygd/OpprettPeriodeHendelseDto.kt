package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.felles.ef.StønadType
import java.time.LocalDate

/**
 * @param personIdenter alle identer til personen
 */
data class OpprettPeriodeHendelseDto(
    val personIdenter: Set<String>,
    val type: StønadType,
    val perioder: List<Periode>
)

data class Periode(val startdato: LocalDate, val sluttdato: LocalDate, val fullOvergangsstønad: Boolean)
