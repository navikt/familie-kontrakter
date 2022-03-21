package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.felles.ef.StønadType

@Deprecated("Erstatt med FinnesIInfotrygdResponse")
data class EksistererStønadResponse(val stønader: Map<StønadType, StønadTreff>)

data class StønadTreff(val eksisterer: Boolean,
                       val harAktivStønad: Boolean)

data class InfotrygdFinnesResponse(val vedtak: List<Vedtakstreff>,
                                   val saker: List<Saktreff>)

data class Vedtakstreff(val personIdent: String, val stønadType: StønadType, val harLøpendeVedtak: Boolean)
data class Saktreff(val personIdent: String, val stønadType: StønadType)
