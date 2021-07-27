package no.nav.familie.kontrakter.ef.ettersending

import java.time.LocalDateTime

data class EttersendingResponseData(val ettersendingDto: EttersendingDto,
                                   val mottattTidspunkt: LocalDateTime)
