package no.nav.familie.kontrakter.felles.dokarkiv

import no.nav.familie.kontrakter.felles.BrukerIdType

data class DokarkivBruker(
    val idType: BrukerIdType,
    val id: String,
)
