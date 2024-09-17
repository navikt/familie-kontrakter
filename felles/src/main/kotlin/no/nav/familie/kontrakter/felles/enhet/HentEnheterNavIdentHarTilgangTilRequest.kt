package no.nav.familie.kontrakter.felles.enhet

import no.nav.familie.kontrakter.felles.NavIdent
import no.nav.familie.kontrakter.felles.Tema

data class HentEnheterNavIdentHarTilgangTilRequest(
    val navIdent: NavIdent,
    val tema: Tema,
)
