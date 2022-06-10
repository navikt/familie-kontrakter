package no.nav.familie.kontrakter.ks.søknad

data class OppgittUtlandsTilknytning(
    val aktørerArbeidYtelseIUtlandet: Set<AktørArbeidYtelseUtland>,
    val aktørerTilknytningTilUtlandet: Set<AktørTilknytningUtland>
)
