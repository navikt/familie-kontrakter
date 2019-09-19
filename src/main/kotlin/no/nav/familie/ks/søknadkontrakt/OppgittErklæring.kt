package no.nav.familie.ks.søknadkontrakt

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class OppgittErklæring @JsonCreator constructor(

        @JsonProperty("isBarnetHjemmeværendeOgIkkeAdoptert")
        val isBarnetHjemmeværendeOgIkkeAdoptert: Boolean,

        @JsonProperty("isBorSammenMedBarnet")
        val isBorSammenMedBarnet: Boolean,

        @JsonProperty("isIkkeAvtaltDeltBosted")
        val isIkkeAvtaltDeltBosted: Boolean,

        @JsonProperty("isBarnINorgeNeste12Måneder")
        val isBarnINorgeNeste12Måneder: Boolean

)
