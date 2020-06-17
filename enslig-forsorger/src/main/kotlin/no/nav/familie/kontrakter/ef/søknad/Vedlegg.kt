package no.nav.familie.kontrakter.ef.søknad

data class Vedlegg(val id: String, val navn: String, val tittel: String, val bytes: ByteArray) {

    override fun toString(): String {
        return "Vedlegg(id='$id', navn='$navn', tittel='$tittel')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vedlegg

        if (id != other.id) return false
        if (navn != other.navn) return false
        if (tittel != other.tittel) return false
        if (!bytes.contentEquals(other.bytes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + navn.hashCode()
        result = 31 * result + tittel.hashCode()
        result = 31 * result + bytes.contentHashCode()
        return result
    }


}
