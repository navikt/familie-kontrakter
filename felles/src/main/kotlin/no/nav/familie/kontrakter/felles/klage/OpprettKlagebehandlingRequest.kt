package no.nav.familie.kontrakter.felles.klage

import java.time.LocalDate

data class OpprettKlagebehandlingRequest(
    val ident: String,
    val stønadstype: Stønadstype,
    val eksternFagsakId: String,
    val fagsystem: Fagsystem,
    val klageMottatt: LocalDate,
    val behandlendeEnhet: String,
    val klageGjelderTilbakekreving: Boolean = false,
)
