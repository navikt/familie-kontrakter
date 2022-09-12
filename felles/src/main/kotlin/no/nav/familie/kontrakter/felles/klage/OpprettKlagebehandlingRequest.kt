package no.nav.familie.kontrakter.felles.klage

import no.nav.familie.kontrakter.felles.Fagsystem
import no.nav.familie.kontrakter.felles.Ytelsestype
import java.time.LocalDate

data class OpprettKlagebehandlingRequest(
    val ident: String,
    val ytelsestype: Ytelsestype,
    val eksternBehandlingId: String,
    val eksternFagsakId: String,
    val fagsystem: Fagsystem,
    val klageMottatt: LocalDate
)