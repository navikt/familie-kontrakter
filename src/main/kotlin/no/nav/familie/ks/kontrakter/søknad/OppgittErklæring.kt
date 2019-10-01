package no.nav.familie.ks.kontrakter.søknad

data class OppgittErklæring(
        val isBarnetHjemmeværendeOgIkkeAdoptert: Boolean,
        val isBorSammenMedBarnet: Boolean,
        val isIkkeAvtaltDeltBosted: Boolean,
        val isBarnINorgeNeste12Måneder: Boolean
)
