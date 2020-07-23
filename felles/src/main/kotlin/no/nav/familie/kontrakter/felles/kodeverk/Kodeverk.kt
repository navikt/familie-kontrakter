package no.nav.familie.kontrakter.felles.kodeverk

import java.time.LocalDate

data class KodeverkDto(val betydninger: Map<String, List<BetydningDto>>)

data class BetydningDto(val gyldigFra: LocalDate,
                        val gyldigTil: LocalDate,
                        val beskrivelser: Map<String, BeskrivelseDto>)

data class BeskrivelseDto(val term: String,
                          val tekst: String)

enum class KodeverkSpråk(val kode: String) {
    BOKMÅL("nb")
}

private fun LocalDate.mellom(fra: LocalDate, til: LocalDate) =
        this.isEqual(fra) || this.isEqual(til) || (this.isAfter(fra) && this.isBefore(til))

fun KodeverkDto.hentGjeldende(kode: String,
                              gjeldendeDato: LocalDate = LocalDate.now(),
                              språk: KodeverkSpråk = KodeverkSpråk.BOKMÅL) =
        betydninger[kode]
                ?.firstOrNull { gjeldendeDato.mellom(it.gyldigFra, it.gyldigTil) }
                ?.beskrivelser?.get(språk.kode)?.term
