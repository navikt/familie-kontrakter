package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.felles.ef.StønadType

data class InfotrygdFinnesResponse(
    val vedtak: List<Vedtakstreff>,
    val saker: List<Saktreff>
)

data class Vedtakstreff(val personIdent: String, val stønadType: StønadType, val harLøpendeVedtak: Boolean)
data class Saktreff(val personIdent: String, val stønadType: StønadType)
