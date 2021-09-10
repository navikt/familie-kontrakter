package no.nav.familie.kontrakter.ef.ettersending;

import no.nav.familie.kontrakter.ef.felles.StønadType

data class EttersendingDto(val fnr: String,
                           val stønadType: StønadType,
                           val ettersendingForSøknad: EttersendingForSøknad?,
                           val ettersendingUtenSøknad: EttersendingUtenSøknad?)