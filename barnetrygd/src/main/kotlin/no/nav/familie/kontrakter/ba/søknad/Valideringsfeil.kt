package no.nav.familie.kontrakter.ba.søknad

import no.nav.familie.kontrakter.ba.søknad.v4.Locale

/**
 * Representerer valideringsfeil i søknaden.
 *
 * @param objectPath Sti til objektet som feilet validering
 * @param locale Språket til verdien som feilet validering
 * @param feilmelding Beskrivelse av valideringsfeilen
 */
data class Valideringsfeil(
    val objectPath: String,
    val locale: Locale,
    val feilmelding: String,
)

const val MAKS_LENGDE = 200
val UGYLDIGE_TEGN_REGEX = Regex("[<>\"]")
