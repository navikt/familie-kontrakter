package no.nav.familie.ks.søknadkontrakt

data class OppgittUtlandsTilknytning(
        val aktørerArbeidYtelseIUtlandet: Set<AktørArbeidYtelseUtland>,
        val aktørerTilknytningTilUtlandet: Set<AktørTilknytningUtland>
)