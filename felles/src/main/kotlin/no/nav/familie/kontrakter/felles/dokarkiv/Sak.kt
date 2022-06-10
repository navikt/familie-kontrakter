package no.nav.familie.kontrakter.felles.dokarkiv

import no.nav.familie.kontrakter.felles.Fagsystem

data class Sak(
    val arkivsaksnummer: String? = null,
    val arkivsaksystem: String? = null,
    val fagsakId: String? = null,
    val fagsaksystem: Fagsystem? = null,
    val sakstype: String? = null
)
