package no.nav.familie.kontrakter.felles.oppgave

import no.nav.familie.kontrakter.felles.abstraction.QueryObject

data class FinnMappeRequest(val tema: List<String>? = null,
                            val enhetsnr: String,
                            val opprettetFom: String?,
                            val limit: Int = 1000) :
        QueryObject()
