package no.nav.familie.kontrakter.ef.infotrygd

data class SøkFlereStønaderRequest(val identer: Set<String>,
                                   val stønader: Set<StønadType>)