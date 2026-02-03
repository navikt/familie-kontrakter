package no.nav.familie.kontrakter.felles

data class Organisasjonsnummer(
    val verdi: String,
) {
    init {
        check(gyldig()) { "Ugyldig organisasjonsnummer: $verdi" }
    }

    val erSyntetisk: Boolean get() = verdi.startsWith("2") || verdi.startsWith("3")

    private fun gyldig(): Boolean {
        if (verdi.length != 9 || verdi.toLongOrNull() == null) {
            return false
        }

        val siffer = verdi.chunked(1).map { it.toInt() }
        val vekting = listOf(3, 2, 7, 6, 5, 4, 3, 2)
        val kontrollMod = 11 - (0..7).sumOf { siffer[it] * vekting[it] } % 11

        return siffer.last() == kontrollMod
    }

    override fun toString(): String = verdi.chunked(3).joinToString(" ")
}
