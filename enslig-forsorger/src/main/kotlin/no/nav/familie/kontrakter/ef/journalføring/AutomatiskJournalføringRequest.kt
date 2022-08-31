package no.nav.familie.kontrakter.ef.journalføring

import no.nav.familie.kontrakter.felles.ef.StønadType

data class AutomatiskJournalføringRequest(
    val personIdent: String,
    val journalpostId: String,
    val stønadType: StønadType
)
