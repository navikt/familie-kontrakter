package no.nav.familie.kontrakter.felles.tilgangskontroll

data class Tilgang(
    val harTilgang: Boolean,
    val begrunnelse: String? = null,
)
