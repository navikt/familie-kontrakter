package no.nav.familie.kontrakter.felles.oppdrag

@Deprecated(message = "Trenger å sende med periodeIdn",
            replaceWith = ReplaceWith("no.nav.familie.kontrakter.felles.oppdrag.OppdragIdForFagsystemV2"))
data class OppdragIdForFagsystem(val personIdent: String,
                                 val behandlingsId: Long) {
    override fun toString(): String = "OppdragId(behandlingsId=$behandlingsId)"
}