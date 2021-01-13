package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.ef.felles.StønadType

data class OpprettStartBehandlingHendelseDto(val fnr: String,
                                             val type: StønadType)