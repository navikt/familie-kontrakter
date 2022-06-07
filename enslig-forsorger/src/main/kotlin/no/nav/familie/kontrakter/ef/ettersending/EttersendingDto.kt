package no.nav.familie.kontrakter.ef.ettersending

import no.nav.familie.kontrakter.felles.ef.StønadType

@Deprecated("Erstattes av EttersendelseDto")
data class EttersendingDto(
    val fnr: String,
    val stønadType: StønadType,
    val ettersendingForSøknad: EttersendingForSøknad?,
    val ettersendingUtenSøknad: EttersendingUtenSøknad?
)
