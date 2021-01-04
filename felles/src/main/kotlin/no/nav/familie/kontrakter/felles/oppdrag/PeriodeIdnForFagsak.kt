package no.nav.familie.kontrakter.felles.oppdrag

data class PeriodeIdnForFagsak(val fagsakId: String,
                               val periodeIdn: Set<Long>) {
    override fun toString(): String = "OppdragId(periodeIdn=$periodeIdn)"
}