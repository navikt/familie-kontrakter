package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.felles.ef.StønadType

/**
 * @param personIdenter alle identer til personen
 */
data class OpprettStartBehandlingHendelseDto(
    val personIdenter: Set<String>,
    val type: StønadType
)
