package no.nav.familie.kontrakter.felles.dokarkiv.v2

import no.nav.familie.kontrakter.felles.Språkkode

data class Førsteside(
    val språkkode: Språkkode = Språkkode.NB,
    val navSkjemaId: String,
    val overskriftstittel: String,
)
