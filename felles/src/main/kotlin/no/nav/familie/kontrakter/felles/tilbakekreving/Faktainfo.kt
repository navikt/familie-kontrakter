package no.nav.familie.kontrakter.felles.tilbakekreving

import com.fasterxml.jackson.annotation.JsonFormat

data class Faktainfo(
        val revurderingsårsak: String,
        val revurderingsresultat: String,
        val tilbakekrevingsvalg: Tilbakekrevingsvalg,
        val konsekvensForYtelser: Set<String> = emptySet()
)

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class Tilbakekrevingsvalg(val tekst: String) {

    OPPRETT_TILBAKEKREVING_MED_VARSEL("Opprett tilbakekreving, send varsel"),
    OPPRETT_TILBAKEKREVING_UTEN_VARSEL("Opprett tilbakekreving, ikke send varsel"),
    IGNORER_TILBAKEKREVING("Avvent tilbakekreving")
}
