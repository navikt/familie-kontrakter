package no.nav.familie.kontrakter.felles.klage

import no.nav.familie.kontrakter.felles.Fagsystem
import java.time.LocalDate

data class OpprettKlagebehandlingRequest(
    val ident: String,
    val stønadstype: Stønadstype,
    val eksternBehandlingId: String,
    val eksternFagsakId: String,
    val fagsystem: Fagsystem,
    val klageMottatt: LocalDate,
    val behandlendeEnhet: String
)