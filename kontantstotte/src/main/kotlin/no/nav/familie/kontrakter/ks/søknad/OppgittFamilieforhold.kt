package no.nav.familie.kontrakter.ks.søknad

data class OppgittFamilieforhold(
    val barna: Set<Barn>,
    val borBeggeForeldreSammen: Boolean,
    val oppgittAnnenPartNavn: String?
)