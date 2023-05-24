package no.nav.familie.kontrakter.felles.journalpost

import no.nav.familie.kontrakter.felles.Tema

data class JournalposterForBrukerRequest(
    val brukerId: Bruker,
    val antall: Int,
    val tema: List<Tema>? = null,
    val journalposttype: List<Journalposttype>? = null,
)
