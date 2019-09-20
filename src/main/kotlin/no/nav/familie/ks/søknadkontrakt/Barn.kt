package no.nav.familie.ks.søknadkontrakt

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class Barn @JsonCreator constructor(
    @JsonProperty("barnehageStatus")
    val barnehageStatus: BarnehageplassStatus,

    @JsonProperty("barnehageAntallTimer")
    val barnehageAntallTimer: Double,

    @JsonProperty("barnehageDato")
    val barnehageDato: LocalDate,

    @JsonProperty("barnehageKommune")
    val barnehageKommune: String
)