package no.nav.familie.kontrakter.felles.simulering

enum class FagOmrådeKode(val kode: String) {
    BARNETRYGD("BA"),
    BARNETRYGD_INFOTRYGD("IT05"),
    BARNETRYGD_INFOTRYGD_MANUELT("MIT05"),
    ENSLIG_FORSØRGER_OVERGANGSSTØNAD("EFOG"),
    ENSLIG_FORSØRGER_OVERGANGSSTØNAD_INFOTRYGD("EFOGNY"),
    ENSLIG_FORSØRGER_OVERGANGSSTØNAD_MANUELL_POSTERING("MEFOGNY"),
    ENSLIG_FORSØRGER_SKOLEPENGER("EFSP"),
    ENSLIG_FORSØRGER_SKOLEPENGER_INFOTRYGD("IT30UT"),
    ENSLIG_FORSØRGER_BARNETILSYN("EFBT"),
    ENSLIG_FORSØRGER_BARNETILSYN_INFOTRYGD("IT30BT"),
    TILBAKEKREVING_EF_MANUELL_POSTERING("MEFTB"),
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
