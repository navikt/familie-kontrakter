package no.nav.familie.kontrakter.ef.iverksett

import no.nav.familie.kontrakter.ef.felles.StønadType
import java.time.LocalDate
import java.util.UUID

data class TekniskOpphørDto(
        val forrigeBehandlingId: UUID,
        val saksbehandlerId: String,
        val eksternBehandlingId: Long,
        val stønadstype: StønadType,
        val eksternFagsakId: Long,
        val personIdent: String,
        val behandlingId: UUID,
        val vedtaksdato: LocalDate
)