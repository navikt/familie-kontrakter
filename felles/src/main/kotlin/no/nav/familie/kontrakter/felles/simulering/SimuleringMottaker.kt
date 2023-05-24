package no.nav.familie.kontrakter.felles.simulering

data class SimuleringMottaker(
    val simulertPostering: List<SimulertPostering>, // perioder
    val mottakerNummer: String? = null,
    val mottakerType: MottakerType,
) {

    override fun toString(): String {
        return (
            javaClass.simpleName +
                "< mottakerType=" + mottakerType +
                ">"
            )
    }
}
