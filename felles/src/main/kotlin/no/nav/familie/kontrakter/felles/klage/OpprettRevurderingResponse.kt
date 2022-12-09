package no.nav.familie.kontrakter.felles.klage

data class OpprettRevurderingResponse internal constructor(
    val opprettetBehandling: Boolean,
    val opprettet: Opprettet? = null,
    val ikkeOpprettet: IkkeOpprettet? = null
) {

    constructor(opprettet: Opprettet) : this(true, opprettet = opprettet)
    constructor(ikkeOpprettet: IkkeOpprettet) : this(false, ikkeOpprettet = ikkeOpprettet)

    init {
        if (opprettetBehandling) {
            require(opprettet != null) { "opprettet mangler" }
            require(ikkeOpprettet == null) { "ikkeOpprettet må være null" }
        } else {
            require(ikkeOpprettet != null) { "ikkeOpprettet mangler" }
            require(opprettet == null) { "opprettet må være null" }
        }
    }
}

data class Opprettet(val eksternBehandlingId: String)

data class IkkeOpprettet(
    val årsak: IkkeOpprettetÅrsak,
    val detaljer: String? = null
)

enum class IkkeOpprettetÅrsak {
    ÅPEN_BEHANDLING,
    INGEN_BEHANDLING,
    FEIL
}
