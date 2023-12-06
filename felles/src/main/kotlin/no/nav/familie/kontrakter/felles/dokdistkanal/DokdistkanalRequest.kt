package no.nav.familie.kontrakter.felles.dokdistkanal

import no.nav.familie.kontrakter.felles.PersonIdent

data class DokdistkanalRequest(
    val bruker: PersonIdent,
    val mottaker: PersonIdent,
    val dokumenttypeId: String? = null,
    val erArkivert: Boolean? = null,
    val forsendelseStørrelseIMegabytes: Int? = null,
)
