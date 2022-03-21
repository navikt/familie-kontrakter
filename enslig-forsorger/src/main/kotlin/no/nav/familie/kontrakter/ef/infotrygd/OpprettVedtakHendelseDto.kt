package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.felles.ef.StønadType
import java.time.LocalDate

/**
 * @param personIdenter alle identer til personen
 */
data class OpprettVedtakHendelseDto(val personIdenter: Set<String>,
                                    val type: StønadType,
                                    val startdato: LocalDate)