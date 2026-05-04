package no.nav.familie.kontrakter.felles.dokarkiv

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class AvsluttSakRequest(
    val tema: String,
    val fagsakId: String,
    val fagsaksystem: String,
    val bruker: DokarkivBruker,
    val opprettetDato: LocalDateTime,
    val administrativEnhet: String,
    val avsluttetDato: LocalDateTime? = null,
    val sakAnsvarlig: String? = null,
)
