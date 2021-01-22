package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.ef.felles.StønadType

/**
 * @param personIdenter alle identer til personen
 */
data class SøkFlereStønaderRequest(val personIdenter: Set<String>,
                                   val stønader: Set<StønadType>)