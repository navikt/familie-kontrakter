package  no.nav.familie.kontrakter.ef.iverksett

import java.time.LocalDate

data class InntektDto(
        val beløp: Int,
        val samordningsfradrag: Int,
        var periodetype: Periodetype,
        val fraOgMed: LocalDate,
        val tilOgMed: LocalDate,
)
