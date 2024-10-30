package no.nav.familie.kontrakter.felles.dokarkiv

import no.nav.familie.kontrakter.felles.journalpost.AvsenderMottakerIdType

data class AvsenderMottaker(
    val id: String?,
    val idType: AvsenderMottakerIdType?,
    val navn: String,
)
