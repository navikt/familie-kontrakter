package no.nav.familie.kontrakter.felles.klage

enum class BehandlingResultat(val displayName: String) {
    MEDHOLD(displayName = "Medhold"),
    IKKE_MEDHOLD(displayName = "Ikke medhold"),
    IKKE_SATT(displayName = "Ikke satt"),
}

enum class BehandlingStatus {
    OPPRETTET,
    UTREDES,
    VENTER,
    FERDIGSTILT;
}

enum class Årsak {
    FEIL_I_LOVANDVENDELSE,
    FEIL_REGELVERKSFORSTÅELSE,
    FEIL_ELLER_ENDRET_FAKTA,
    FEIL_PROSESSUELL,
    KØET_BEHANDLING,
    ANNET
}