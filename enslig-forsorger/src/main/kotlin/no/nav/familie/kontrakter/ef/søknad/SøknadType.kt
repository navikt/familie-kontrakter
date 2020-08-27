package no.nav.familie.kontrakter.ef.søknad

enum class SøknadType(val dokumentType: String, val dokumentTypeVedlegg: String? = null) {
    OVERGANGSSTØNAD("OVERGANGSSTØNAD_SØKNAD", "OVERGANGSSTØNAD_SØKNAD_VEDLEGG"),
    BARNETILSYN("BARNETILSYNSTØNAD_SØKNAD", "BARNETILSYNSTØNAD_VEDLEGG"),
    SKOLEPENGER("SKOLEPENGER_SØKNAD", "SKOLEPENGER_VEDLEGG"),
    OVERGANGSSTØNAD_ARBEIDSSØKER("SKJEMA_ARBEIDSSØKER");

    companion object {
        private val dokumenttypeMap = values().associateBy(SøknadType::dokumentType)
        fun hentSøknadTypeForDokumenttype(dokumentType: String): SøknadType {
            return dokumenttypeMap[dokumentType] ?: throw error("Fant ikke søknadtype for dokumenttype $dokumentType")
        }
    }
}