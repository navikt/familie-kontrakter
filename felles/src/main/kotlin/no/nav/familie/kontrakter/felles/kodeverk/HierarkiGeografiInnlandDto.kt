package no.nav.familie.kontrakter.felles.kodeverk

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class HierarkiGeografiInnlandDto(
    val noder: NoderInnland,
) {
    val norgeNode: LandDto
        get() = requireNotNull(noder.innland.undernoder["NOR"]) { "Fant ikke undernode 'NOR'" }
}

data class NoderInnland(
    @param:JsonProperty("INNLAND") val innland: Innland,
)

data class Innland(
    val undernoder: Map<String, LandDto>,
)

data class LandDto(
    private val undernoder: Map<String, Fylke>,
) {
    val fylker: List<Fylke> get() = undernoder.values.toList()
}

data class Fylke(
    val kode: String,
    private val tekster: Map<String, String>,
    private val termer: Map<String, String>,
    private val undernoder: Map<String, Kommune>,
) {
    val navn: String get() = tekster.getValue("nb")
    val kommuner: List<Kommune> get() = undernoder.values.toList()
}

data class Kommune(
    val kode: String,
    private val tekster: Map<String, String>,
    private val termer: Map<String, String>,
    private val undernoder: Map<String, Bydel>? = null,
) {
    val navn: String get() = tekster.getValue("nb")
    val bydeler: List<Bydel> get() = undernoder?.values?.toList() ?: emptyList()
}

data class Bydel(
    val kode: String,
    private val tekster: Map<String, String>,
    private val termer: Map<String, String>,
) {
    val navn: String get() = tekster.getValue("nb")
}
