package no.nav.familie.kontrakter.felles.historikkinnslag

import java.util.UUID

data class OpprettHistorikkinnslagRequest(val behandlingId: UUID,
                                          val eksternFagsakId: String,
                                          val historikkinnslagType: HistorikkinnslagType,
                                          val tittel: String,
                                          val tekst: String? = null,
                                          val historikkinnslagFeltType: HistorikkinnslagFeltType? = null,
                                          val lenke: String? = null,
                                          val journalpostId: String? = null,
                                          val dokumentId: String? = null)

enum class HistorikkinnslagType {
    BEHANDLING_OPPRETTET,
    REVURDERING_OPPRETTET,
    BEHANDLING_SETT_PÅ_VENT,
    BEHANDLING_GJENOPPTATT,
    BEHANDLING_AVSLUTTET,
    KRAVGRUNNLAG_MOTTATT,
    KRAVGRUNNLAG_INNHENTET,
    STEG_VURDERT,
    SEND_TIL_BESLUTTER,
    VEDTAK_FATTET,
    VARSELBREV_SENDT,
    VEDTAKSBREV_SENDT,
    HENLEGGELSESBREV_SENDT,
    INNHENTDOKUMENTASJON_SENDT,
    REGISTERT_VERGE,
    FJERNET_VERGE
}

enum class HistorikkinnslagFeltType {
    HENDELSE,
    SKJERMLENKE,
    RESULTAT,
    ÅRSAK
}
