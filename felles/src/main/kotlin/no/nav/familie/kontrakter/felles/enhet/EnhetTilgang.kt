package no.nav.familie.kontrakter.felles.enhet

data class EnhetTilgang(val enheter: List<Enhet>)

data class Enhet(val enhetsnummer: String) {
    init {
        if (enhetsnummer.length != 4) throw IllegalArgumentException("Enhetsnummer må være 4 siffer")
    }
}
