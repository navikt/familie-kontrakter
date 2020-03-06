package no.nav.familie.kontrakter.felles.personopplysning.tilhørighet

data class Landkode(val kode: String) {

    fun erNorge(): Boolean {
        return NORGE == this
    }

    companion object {
        val UDEFINERT = Landkode("UDEFINERT")
        val NORGE = Landkode("NOR")
    }
}