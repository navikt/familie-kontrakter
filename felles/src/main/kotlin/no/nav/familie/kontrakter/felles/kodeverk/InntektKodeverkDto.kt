package no.nav.familie.kontrakter.felles.kodeverk

typealias InntektKodeverkDto = Map<InntektKodeverkType, Map<String, String>>

enum class InntektKodeverkType(val kodeverk: String) {
    LOENNSINNTEKT("Loennsbeskrivelse"),
    NAERINGSINNTEKT("Naeringsinntektsbeskrivelse"),
    PENSJON_ELLER_TRYGD("PensjonEllerTrygdeBeskrivelse"),
    YTELSE_FRA_OFFENTLIGE("YtelseFraOffentligeBeskrivelse"),
    TILLEGSINFORMASJON_KATEGORI("EDAGTilleggsinfoKategorier")
}