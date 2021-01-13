package no.nav.familie.kontrakter.ef.infotrygd

data class EksistererStønadResponse(val stønader: Map<StønadType, StønadTreff>)

data class StønadTreff(val eksisterer: Boolean,
                       val harAktivStønad: Boolean)