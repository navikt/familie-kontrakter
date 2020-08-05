package no.nav.familie.kontrakter.felles.journalpost

import no.nav.familie.kontrakter.felles.abstraction.QueryObject
import no.nav.familie.kontrakter.felles.oppgave.Tema

data class JournalposterForBrukerRequest(val brukerId: Bruker,
                                         val første: Int,
                                         val tema: List<Tema>?=null,
                                         val journalposttype: List<Journalposttype>?=null) : QueryObject()
