package no.nav.familie.ks.søknadkontrakt

data class OppgittFamilieforhold(
    val barna: Set<Barn>,
    val borBeggeForeldreSammen: Boolean
)