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

/**
 * @param sisteGjeldende henter siste gjeldende verdi for en gitt kode hvis den mangler for gitt dato
 */
fun KodeverkDto.hentGjeldende(kode: String,
                              gjeldendeDato: LocalDate = LocalDate.now(),
                              språk: KodeverkSpråk = KodeverkSpråk.BOKMÅL,
                              sisteGjeldende: Boolean = false): String? {
    val betydningForKode = betydninger[kode] ?: return null
    var betydning = betydningForKode.firstOrNull { gjeldendeDato.mellom(it.gyldigFra, it.gyldigTil) }
    if (betydning == null && sisteGjeldende) {
        betydning = betydningForKode.maxByOrNull { it.gyldigFra }
    }
    return betydning?.beskrivelser?.get(språk.kode)?.term
}
