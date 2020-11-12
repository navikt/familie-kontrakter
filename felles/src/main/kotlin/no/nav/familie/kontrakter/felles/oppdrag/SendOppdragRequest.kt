package no.nav.familie.kontrakter.felles.oppdrag

data class SendtOppdragRequest(
        val utbetalingsoppdrag: Utbetalingsoppdrag,
        val gjeldendeBehandlingId: Long
)