package no.nav.familie.kontrakter.felles.oppgave


data class FinnMappeResponseDto(
        val antallTreffTotalt: Int,
        val mapper: List<MappeDto>
)

data class MappeDto(
        val id: Int,
        val navn: String,
)