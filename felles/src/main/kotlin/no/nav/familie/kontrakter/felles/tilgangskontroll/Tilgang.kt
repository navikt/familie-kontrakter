package no.nav.familie.kontrakter.felles.tilgangskontroll

/**
 * @param personIdent er identen på den personen man har sjekket tilgang på
 * I de tilfeller der man sender en ident for å sjekker tilgang på personMedRelasjoner,
 * så returnerer man fortsatt bare identen til den person som man etterspurt
 */
data class Tilgang(
    val harTilgang: Boolean,
    val begrunnelse: String? = null,
    val personIdent: String? = null,
)
