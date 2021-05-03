package no.nav.familie.kontrakter.felles.simulering

enum class FagOmrådeKode(val kode: String) {
    BARNETRYGD("BA"),
    BARNETRYGD_INFOTRYGD("IT05"),
    BARNETRYGD_INFOTRYGD_MANUELT("MIT05"),
    ENSLIG_FORSØRGER("EF"),
    ENSLIG_FORSØRGER_REFUSJON("EFREF"),
    KONTANTSTØTTE("KS");

    companion object {

        fun fraKode(kode: String): FagOmrådeKode {
            for (fagOmrådeKode in values()) {
                if (fagOmrådeKode.kode == kode) {
                    return fagOmrådeKode
                }
            }
            throw IllegalArgumentException("FagOmrådeKode finnes ikke for kode $kode")
        }
    }

}
