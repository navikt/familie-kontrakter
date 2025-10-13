package no.nav.familie.kontrakter.ba.finnmarkstillegg

enum class KommunerIFinnmarkOgNordTroms(
    val kommunenummer: List<String>,
) {
    // Finnmark
    ALTA(listOf("5403","5601")),
    HAMMERFEST(listOf("5406","5603")),
    SØR_VARANGER(listOf("5444","5605")),
    VADSØ(listOf("5405","5607")),
    KARASJOK(listOf("5437","5610")),
    KAUTOKEINO(listOf("5430", "5612")),
    LOPPA(listOf("5432","5614")),
    HASVIK(listOf("5433","5616")),
    MÅSØY(listOf("5434","5618")),
    NORDKAPP(listOf("5435","5620")),
    PORSANGER(listOf("5436","5622")),
    LEBESBY(listOf("5438","5624")),
    GAMVIK(listOf("5439","5626")),
    TANA(listOf("5441","5628")),
    BERLEVÅG(listOf("5440","5630")),
    BÅTSFJORD(listOf("5443","5632")),
    VARDØ(listOf("5404","5634")),
    NESSEBY(listOf("5442","5636")),

    // Nord-Troms
    KARLSØY(listOf("5423","5534")),
    LYNGEN(listOf("5424","5536")),
    STORFJORD(listOf("5425","5538")),
    KÅFJORD(listOf("5426","5540")),
    SKJERVØY(listOf("5427","5542")),
    NORDREISA(listOf("5428","5544")),
    KVÆNANGEN(listOf("5429","5546")),
}

fun kommuneErIFinnmarkEllerNordTroms(kommunenummer: String): Boolean =
    KommunerIFinnmarkOgNordTroms.entries.any {
        kommunenummer in it.kommunenummer
    }
