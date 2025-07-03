package no.nav.familie.kontrakter.felles.enhet

data class Enhet(
    val enhetsnummer: String,
    val enhetsnavn: String,
) {
    init {
        if (enhetsnummer.length != 4) throw IllegalArgumentException("Enhetsnummer må være 4 siffer")
    }
}
