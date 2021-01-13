package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.ef.felles.StønadType
import java.time.LocalDate

data class OpprettVedtakHendelseDto(val fnr: String,
                                    val type: StønadType,
                                    val startdato: LocalDate)