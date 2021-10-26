package no.nav.familie.kontrakter.felles.oppgave


data class FinnMappeResponseDto(
        val antallTreffTotalt: Int,
        val mapper: List<MappeDto>
)

data class MappeDto(
        val endretAv: String,
        val endretTidspunkt: String,
        val enhetsnr: String,
        val id: Int,
        val navn: String,
        val opprettetAv: String,
        val opprettetTidspunkt: String,
        val tema: String,
        val versjon: Int
)