package no.nav.familie.ks.søknadkontrakt

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class OppgittFamilieforhold @JsonCreator constructor(
    @JsonProperty("barna")
    val barna: Set<Barn>,

    @JsonProperty("borBeggeForeldreSammen")
    val borBeggeForeldreSammen: Boolean
)