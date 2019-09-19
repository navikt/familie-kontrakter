package no.nav.familie.ks.søknadkontrakt

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class TilknytningTilUtland @JsonCreator constructor (

        @JsonProperty("annenForelderBoddEllerJobbetINorgeMinstFemAar")
        var annenForelderBoddEllerJobbetINorgeMinstFemAar: TilknytningTilUtlandVerdier? = null,

        @JsonProperty("annenForelderBoddEllerJobbetINorgeMinstFemAarForklaring")
        var annenForelderBoddEllerJobbetINorgeMinstFemAarForklaring: String? = null,

        @JsonProperty("boddEllerJobbetINorgeMinstFemAar")
        var boddEllerJobbetINorgeMinstFemAar: TilknytningTilUtlandVerdier? = null,

        @JsonProperty("boddEllerJobbetINorgeMinstFemAarForklaring")
        var boddEllerJobbetINorgeMinstFemAarForklaring: String? = null
)