package no.nav.familie.ks.søknadkontrakt

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class AktørArbeidYtelseUtland @JsonCreator constructor (

        @JsonProperty("aktørId")
        val aktørId: String,

        @JsonProperty("utlandsTilknytning")
        val utlandsTilknytning: OppgittUtlandsTilknytning?,

        @JsonProperty("arbeidIUtlandet")
        val arbeidIUtlandet: Standpunkt,

        @JsonProperty("arbeidIUtlandetForklaring")
        val arbeidIUtlandetForklaring: String,

        @JsonProperty("ytelseIUtlandet")
        val ytelseIUtlandet: Standpunkt,

        @JsonProperty("ytelseIUtlandetForklaring")
        val ytelseIUtlandetForklaring: String,

        @JsonProperty("kontantstøtteIUtlandet")
        val kontantstøtteIUtlandet: Standpunkt,

        @JsonProperty("kontantstøtteIUtlandetForklaring")
        val kontantstøtteIUtlandetForklaring: String

)
