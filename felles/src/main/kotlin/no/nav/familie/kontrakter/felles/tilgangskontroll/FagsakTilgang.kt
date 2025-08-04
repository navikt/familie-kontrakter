package no.nav.familie.kontrakter.felles.tilgangskontroll

data class FagsakTilgang(
    val harTilgang: Boolean,
    val begrunnelse: String? = null,
)
