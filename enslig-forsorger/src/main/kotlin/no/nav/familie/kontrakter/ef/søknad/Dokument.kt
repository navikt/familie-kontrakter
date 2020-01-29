package no.nav.familie.kontrakter.ef.søknad

class Dokument(val bytes: ByteArray, val tittel: String) {

    override fun toString(): String {
        return tittel
    }

}

