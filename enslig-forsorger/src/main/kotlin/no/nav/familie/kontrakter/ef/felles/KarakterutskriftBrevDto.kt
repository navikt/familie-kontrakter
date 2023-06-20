package no.nav.familie.kontrakter.ef.felles

import no.nav.familie.kontrakter.felles.ef.StønadType
import java.time.Year

data class KarakterutskriftBrevDto(
    val fil: ByteArray,
    val oppgaveId: Long,
    val personIdent: String,
    val eksternFagsakId: Long,
    val journalførendeEnhet: String,
    val brevtype: FrittståendeBrevType,
    val gjeldendeÅr: Year,
    val stønadType: StønadType,
)
