package no.nav.familie.kontrakter.felles.simulering

enum class PosteringType(val kode: String) {
    YTELSE("YTEL"),
    FEILUTBETALING("FEIL"),
    FORSKUDSSKATT("SKAT"),
    JUSTERING("JUST");

    companion object {

        fun fraKode(kode: String): PosteringType {
            for (posteringType in values()) {
                if (posteringType.kode == kode) {
                    return posteringType
                }
            }
            throw IllegalArgumentException("PosteringType finnes ikke for kode $kode")
        }
    }
}
