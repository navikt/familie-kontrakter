package no.nav.familie.kontrakter.ba.finnmarkstillegg

enum class KommunerIFinnmarkOgNordTroms(
    val kommunenummer: String,
) {
    // Finnmark
    ALTA("5601"),
    HAMMERFEST("5603"),
    SØR_VARANGER("5605"),
    VADSØ("5607"),
    KARASJOK("5610"),
    KAUTOKEINO("5612"),
    LOPPA("5614"),
    HASVIK("5616"),
    MÅSØY("5618"),
    NORDKAPP("5620"),
    PORSANGER("5622"),
    LEBESBY("5624"),
    GAMVIK("5626"),
    TANA("5628"),
    BERLEVÅG("5630"),
    BÅTSFJORD("5632"),
    VARDØ("5634"),
    NESSEBY("5636"),

    // Nord-Troms
    KARLSØY("5534"),
    LYNGEN("5536"),
    STORFJORD("5538"),
    KÅFJORD("5540"),
    SKJERVØY("5542"),
    NORDREISA("5544"),
    KVÆNANGEN("5546"),
}

fun kommuneErIFinnmarkEllerNordTroms(kommunenummer: String): Boolean =
    KommunerIFinnmarkOgNordTroms.entries.any {
        it.kommunenummer ==
            kommunenummer
    }
