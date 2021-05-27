package no.nav.familie.kontrakter.ef.iverksett

data class TilkjentYtelseDto(
        val andelerTilkjentYtelse: List<AndelTilkjentYtelseDto>
)

enum class TilkjentYtelseStatus {
    IKKE_KLAR,
    OPPRETTET,
    SENDT_TIL_IVERKSETTING,
    AKTIV,
    AVSLUTTET
}


