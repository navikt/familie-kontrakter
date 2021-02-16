package no.nav.familie.kontrakter.felles.tilbakekreving

data class Faktainfo(
        val revurderingsårsaker: Set<String>,
        val revurderingsresultat: String,
        val tilbakekrevingsvalg: Tilbakekrevingsvalg,
        val konsekvensForYtelser: Set<String> = emptySet()
)


enum class Tilbakekrevingsvalg {
    OPPRETT_TILBAKEKREVING_MED_VARSEL,
    OPPRETT_TILBAKEKREVING_UTEN_VARSEL,
    IGNORER_TILBAKEKREVING
}
