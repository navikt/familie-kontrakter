package no.nav.familie.kontrakter.felles.personopplysning

data class FinnPersonidenterResponse(
    val identer: List<PersonIdentMedHistorikk>,
)

data class PersonIdentMedHistorikk(
    val personIdent: String,
    val historisk: Boolean,
)
