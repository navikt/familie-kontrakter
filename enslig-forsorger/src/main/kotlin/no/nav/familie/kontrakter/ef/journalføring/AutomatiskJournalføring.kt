package no.nav.familie.kontrakter.ef.journalføring

import no.nav.familie.kontrakter.felles.ef.StønadType
import no.nav.familie.kontrakter.felles.oppgave.OppgavePrioritet
import java.util.UUID

data class AutomatiskJournalføringRequest(
    val personIdent: String,
    val journalpostId: String,
    val stønadstype: StønadType,
    val mappeId: Long?,
    val prioritet: OppgavePrioritet = OppgavePrioritet.NORM,
)

data class AutomatiskJournalføringResponse(
    val fagsakId: UUID,
    val behandlingId: UUID,
)
