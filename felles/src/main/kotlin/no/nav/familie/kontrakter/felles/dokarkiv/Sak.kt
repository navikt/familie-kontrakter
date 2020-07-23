package no.nav.familie.kontrakter.felles.dokarkiv

data class Sak(val arkivsaksnummer: String? = null,
               val arkivsaksystem: String? = null,
               val fagsakId: String? = null,
               val fagsaksystem: String? = null,
               val sakstype: String? = null)