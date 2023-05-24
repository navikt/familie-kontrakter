package no.nav.familie.kontrakter.felles.dokarkiv

import no.nav.familie.kontrakter.felles.BrukerIdType

data class AvsenderMottaker(
    val id: String?,
    val idType: BrukerIdType?,
    val navn: String,
)
