package no.nav.familie.kontrakter.ef.søknad

@Suppress("ArrayInDataClass")
data class Vedlegg(val id: String, val navn: String, val tittel: String, val bytes: ByteArray) {

    override fun toString(): String {
        return "Vedlegg(id='$id', navn='$navn', tittel='$tittel')"
    }
}
