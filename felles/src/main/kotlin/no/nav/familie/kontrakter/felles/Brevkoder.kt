package no.nav.familie.kontrakter.felles

object Brevkoder {
    const val BARNETRYGD_ORDINÆR_SØKNAD = "NAV 33-00.07"
    const val BARNETRYGD_UTVIDET_SØKNAD = "NAV 33-00.09"

    const val KONTANTSTØTTE_SØKNAD = "NAV 34-00.08"

    const val KLAGE_ANKE = "NAV 90-00.08"
    const val KLAGE = "NAV 90-00.08 K"
    const val ETTERSENDELSE_TIL_KLAGE_ANKE = "NAVe 90-00.08"
    const val ETTERSENDELSE_TIL_KLAGE = "NAVe 90-00.08 K"
    const val ANKE = "NAV 90-00.08 A"
    const val ETTERSENDELSE_TIL_ANKE = "NAVe 90-00.08 A"

    val BARNETRYGD_BREVKODER = listOf(BARNETRYGD_ORDINÆR_SØKNAD, BARNETRYGD_UTVIDET_SØKNAD)

    val KLAGE_BREVKODER = setOf(
        KLAGE_ANKE,
        KLAGE,
        ETTERSENDELSE_TIL_KLAGE_ANKE,
        ETTERSENDELSE_TIL_KLAGE,
        ANKE,
        ETTERSENDELSE_TIL_ANKE
    )
}
