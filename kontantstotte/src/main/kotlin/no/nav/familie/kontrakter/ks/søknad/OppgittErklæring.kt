package no.nav.familie.kontrakter.ks.søknad

data class OppgittErklæring(
    val isBarnetHjemmeværendeOgIkkeAdoptert: Boolean,
    val isBorSammenMedBarnet: Boolean,
    val isIkkeAvtaltDeltBosted: Boolean,
    val isBarnINorgeNeste12Måneder: Boolean,
)
