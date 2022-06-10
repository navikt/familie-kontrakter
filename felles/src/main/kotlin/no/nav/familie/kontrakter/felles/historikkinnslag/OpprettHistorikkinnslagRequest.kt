package no.nav.familie.kontrakter.felles.historikkinnslag

import no.nav.familie.kontrakter.felles.Applikasjon
import no.nav.familie.kontrakter.felles.Fagsystem
import java.time.LocalDateTime

data class OpprettHistorikkinnslagRequest(
    val behandlingId: String,
    val eksternFagsakId: String,
    val fagsystem: Fagsystem,
    val applikasjon: Applikasjon,
    val type: Historikkinnslagstype,
    val aktør: Aktør,
    val aktørIdent: String,
    val opprettetTidspunkt: LocalDateTime,
    val steg: String? = null,
    val tittel: String,
    val tekst: String? = null,
    val journalpostId: String? = null,
    val dokumentId: String? = null
) {

    init {
        when (type) {
            Historikkinnslagstype.SKJERMLENKE -> requireNotNull(steg) { "Steg kan ikke være null for ${this.type}" }
            Historikkinnslagstype.BREV -> {
                requireNotNull(journalpostId) { "journalpostId kan ikke være null for ${this.type}" }
                requireNotNull(dokumentId) { "dokumentId kan ikke være null for ${this.type}" }
                requireNotNull(tekst) { "tekst kan ikke være null for ${this.type}" }
            }
            Historikkinnslagstype.HENDELSE -> check(true)
        }
    }
}

enum class Historikkinnslagstype {
    HENDELSE,
    SKJERMLENKE,
    BREV
}

enum class Aktør {
    SAKSBEHANDLER,
    BESLUTTER,
    VEDTAKSLØSNING
}
