package no.nav.familie.integrasjoner.client.rest

import no.nav.familie.kontrakter.felles.abstraction.QueryObject

data class FinnMappeRequest(val tema: Array<String>, val enhetsnr: String, val opprettetFom: String?, val limit: Int = 1000) :
        QueryObject()
