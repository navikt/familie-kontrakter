package no.nav.familie.kontrakter.felles.dokarkiv

import com.fasterxml.jackson.annotation.JsonInclude
import no.nav.familie.kontrakter.felles.Fagsystem
import no.nav.familie.kontrakter.felles.Tema
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class AvsluttSakRequest(
    val tema: Tema,
    val fagsakId: String,
    val fagsaksystem: Fagsystem,
    val bruker: DokarkivBruker,
    val opprettetDato: LocalDateTime,
    val administrativEnhet: String,
    val avsluttetDato: LocalDateTime? = null,
    val sakAnsvarlig: String? = null,
)
