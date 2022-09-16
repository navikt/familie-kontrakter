package no.nav.familie.kontrakter.felles.klage

enum class BehandlingResultat() {
    MEDHOLD,
    IKKE_MEDHOLD,
    IKKE_MEDHOLD_FORMKRAV_AVVIST,
    IKKE_SATT
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
