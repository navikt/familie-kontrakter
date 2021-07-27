package no.nav.familie.kontrakter.ef.ettersending

import java.time.LocalDateTime

data class EttersendingResponsData(val ettersendingDto: EttersendingDto,
                                   val mottattTidspunkt: LocalDateTime)
