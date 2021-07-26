package no.nav.familie.kontrakter.ef.ettersending;

data class EttersendingDto(val fnr: String,
                           val ettersendingForSøknad: EttersendingForSøknad?,
                           val ettersendingUtenSøknad: EttersendingUtenSøknad?
)
