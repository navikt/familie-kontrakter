package no.nav.familie.kontrakter.felles.oppdrag

data class OppdragId(val fagsystem: String,
                     val personIdent: String,
                     val behandlingId: String) {

    override fun toString(): String = "OppdragId(fagsystem=$fagsystem, behandlingId=$behandlingId)"
}
