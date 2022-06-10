package no.nav.familie.kontrakter.ef.ettersending

import java.time.LocalDateTime

@Deprecated("Etterstattes av EttersendelseDto")
data class EttersendingResponseData(
    val ettersendingDto: EttersendingDto,
    val mottattTidspunkt: LocalDateTime
)
