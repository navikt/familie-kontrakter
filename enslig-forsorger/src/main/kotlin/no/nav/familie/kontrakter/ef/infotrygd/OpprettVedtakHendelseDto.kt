package no.nav.familie.kontrakter.ef.infotrygd

import java.time.LocalDate

data class OpprettVedtakHendelseDto(val fnr: String,
                                    val type: StønadType,
                                    val startdato: LocalDate)