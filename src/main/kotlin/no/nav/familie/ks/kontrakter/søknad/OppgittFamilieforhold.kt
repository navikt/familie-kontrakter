package no.nav.familie.ks.kontrakter.søknad

data class OppgittFamilieforhold(
    val barna: Set<Barn>,
    val borBeggeForeldreSammen: Boolean,
    val oppgittAnnenPartNavn: String?
)