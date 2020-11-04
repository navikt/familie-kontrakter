package no.nav.familie.kontrakter.felles.oppdrag

data class OppdragIdForFagsystem(val personIdent: String,
                                 val behandlingsId: Long) {
    override fun toString(): String = "OppdragId(behandlingsId=$behandlingsId)"
}