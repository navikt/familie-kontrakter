package no.nav.familie.ks.kontrakter.søknad

data class OppgittUtlandsTilknytning(
        val aktørerArbeidYtelseIUtlandet: Set<AktørArbeidYtelseUtland>,
        val aktørerTilknytningTilUtlandet: Set<AktørTilknytningUtland>
)