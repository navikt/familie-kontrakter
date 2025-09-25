package no.nav.familie.kontrakter.felles.kodeverk

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class HierarkiGeografiInnlandDto(
    val noder: NoderInnland,
) {
    val fylker: LandDto
        get() = requireNotNull(noder.INNLAND.undernoder["NOR"]) { "Fant ikke undernode 'NOR'" }
}

data class NoderInnland(
    val INNLAND: Innland,
)

data class Innland(
    val undernoder: Map<String, LandDto>,
)

data class LandDto(
    private val undernoder: Map<String, Fylke>,
) {
    val fylker: Map<String, Fylke> get() = undernoder
}

data class Fylke(
    val kode: String,
    val tekster: Map<String, String>,
    val termer: Map<String, String>,
    val undernoder: Map<String, Kommune>,
) {
    val nb: String get() = tekster.getValue("nb")
}

data class Kommune(
    val kode: String,
    val tekster: Map<String, String>,
    val termer: Map<String, String>,
    val undernoder: Map<String, Bydel>? = null,
) {
    val nb: String get() = tekster.getValue("nb")
}

data class Bydel(
    val kode: String,
    val tekster: Map<String, String>,
    val termer: Map<String, String>,
) {
    val nb: String get() = tekster.getValue("nb")
}
