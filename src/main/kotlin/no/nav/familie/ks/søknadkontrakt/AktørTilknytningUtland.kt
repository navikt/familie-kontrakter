package no.nav.familie.ks.søknadkontrakt

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class AktørTilknytningUtland @JsonCreator constructor (

        @JsonProperty("aktørId")
        val aktørId: String,

        @JsonProperty("tilknytningTilUtland")
        val tilknytningTilUtland: TilknytningTilUtlandVerdier,

        @JsonProperty("tilknytningTilUtlandForklaring")
        val tilknytningTilUtlandForklaring: String

)