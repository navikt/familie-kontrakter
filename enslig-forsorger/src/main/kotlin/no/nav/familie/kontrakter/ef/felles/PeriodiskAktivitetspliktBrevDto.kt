package no.nav.familie.kontrakter.ef.felles

import no.nav.familie.kontrakter.felles.ef.StønadType
import java.time.Year

data class PeriodiskAktivitetspliktBrevDto(
    val fil: ByteArray,
    val oppgaveId: Long,
    val personIdent: String,
    val eksternFagsakId: Long,
    val journalførendeEnhet: String,
    val gjeldendeÅr: Year,
    val stønadType: StønadType,
)
