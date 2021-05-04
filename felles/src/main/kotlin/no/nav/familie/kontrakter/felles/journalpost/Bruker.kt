package no.nav.familie.kontrakter.felles.journalpost

import no.nav.familie.kontrakter.felles.BrukerIdType

data class Bruker(val id: String,
                  val type: BrukerIdType)