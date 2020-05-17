package no.nav.familie.kontrakter.felles.oppdrag

data class OppdragId(val fagsystem : String,
                     val personIdent : String,
                     val behandlingsId : String) {
    override fun toString(): String = "OppdragId(fagsystem=$fagsystem, behandlingsId=$behandlingsId)"
}

val Utbetalingsoppdrag.id : OppdragId
    get() = OppdragId(fagSystem,
                      aktoer,
                      behandlingsIdForFørsteUtbetalingsperiode())