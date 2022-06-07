package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Sivilstandsplaner(
    val harPlaner: Søknadsfelt<Boolean>? = null,
    val fraDato: Søknadsfelt<LocalDate>? = null,
    val vordendeSamboerEktefelle: Søknadsfelt<PersonMinimum>? = null
)
