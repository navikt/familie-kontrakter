package no.nav.familie.ks.søknadkontrakt

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class OppgittUtlandsTilknytning @JsonCreator constructor (

        @JsonProperty("aktørerArbeidYtelseIUtlandet")
        val aktørerArbeidYtelseIUtlandet: Set<AktørArbeidYtelseUtland>,

        @JsonProperty("aktørerTilknytningTilUtlandet")
        val aktørerTilknytningTilUtlandet: Set<AktørTilknytningUtland>

)