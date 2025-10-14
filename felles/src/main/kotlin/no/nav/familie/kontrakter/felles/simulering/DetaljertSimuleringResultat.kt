package no.nav.familie.kontrakter.felles.simulering

data class DetaljertSimuleringResultat(
    val simuleringMottaker: List<SimuleringMottaker>,
    val simuleringMottakerAndreFagsaker: List<SimuleringMottaker> = emptyList(),
)
