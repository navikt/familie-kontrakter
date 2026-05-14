package no.nav.familie.kontrakter.felles.dokarkiv

import no.nav.familie.kontrakter.felles.Fagsystem
import no.nav.familie.kontrakter.felles.Tema

data class GjenåpneSakRequest(
    val tema: Tema,
    val fagsakId: String,
    val fagsaksystem: Fagsystem,
    val bruker: DokarkivBruker,
)
