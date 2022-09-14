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

    fun erLåstForVidereBehandling(): Boolean = listOf(VENTER, FERDIGSTILT).contains(this)
}

enum class Årsak {
    VELG,
    FEIL_I_LOVANDVENDELSE,
    FEIL_REGELVERKSFORSTÅELSE,
    FEIL_ELLER_ENDRET_FAKTA,
    FEIL_PROSESSUELL,
    KØET_BEHANDLING,
    ANNET
}