package no.nav.familie.kontrakter.ef.infotrygd

data class OpprettStartBehandlingHendelseDto(val fnr: String,
                                             val saksnummer: Int,
                                             val type: StønadType)