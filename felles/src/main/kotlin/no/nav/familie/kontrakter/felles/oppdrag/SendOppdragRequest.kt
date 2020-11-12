package no.nav.familie.kontrakter.felles.oppdrag

data class OppdragRequest(
        val utbetalingsoppdrag: Utbetalingsoppdrag,
        val gjeldendeBehandlingId: Long
)