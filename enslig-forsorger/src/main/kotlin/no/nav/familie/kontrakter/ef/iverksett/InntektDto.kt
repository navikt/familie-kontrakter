package  no.nav.familie.kontrakter.ef.iverksett

data class InntektDto(
        val periodebeløp: PeriodebeløpDto,
        val inntektstype: InntektsType? = null
)

data class InntektsreduksjonDto(val periodebeløp: List<PeriodebeløpDto> = emptyList())

enum class InntektsType {
    ARBEIDINNTEKT,
    KAPITALINNTEKT,
    TRYGD_ELLER_STØNAD
}

