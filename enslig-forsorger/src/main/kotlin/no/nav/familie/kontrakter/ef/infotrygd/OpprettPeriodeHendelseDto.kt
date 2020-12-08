package no.nav.familie.kontrakter.ef.infotrygd

import java.time.LocalDate

data class OpprettPeriodeHendelseDto(val fnr: String,
                                     val type: StønadType,
                                     val perioder: List<Periode>)

data class Periode(val startdato: LocalDate, val sluttdato: LocalDate)