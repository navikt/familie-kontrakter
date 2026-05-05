package no.nav.familie.kontrakter.ef.søknad

enum class SøknadType(
    val dokumentType: String,
    val dokumentTypeVedlegg: String? = null,
    val harDokumentasjonsbehov: Boolean = false,
) {
    OVERGANGSSTØNAD("OVERGANGSSTØNAD_SØKNAD", "OVERGANGSSTØNAD_SØKNAD_VEDLEGG", true),
    BARNETILSYN("BARNETILSYNSTØNAD_SØKNAD", "BARNETILSYNSTØNAD_VEDLEGG", true),
    SKOLEPENGER("SKOLEPENGER_SØKNAD", "SKOLEPENGER_VEDLEGG", true),
    OVERGANGSSTØNAD_ARBEIDSSØKER("SKJEMA_ARBEIDSSØKER"),
    ;

    companion object {
        private val dokumenttypeMap = values().associateBy(SøknadType::dokumentType)

        fun hentSøknadTypeForDokumenttype(dokumentType: String): SøknadType =
            dokumenttypeMap[dokumentType] ?: error("Fant ikke søknadtype for dokumenttype $dokumentType")
    }
}
