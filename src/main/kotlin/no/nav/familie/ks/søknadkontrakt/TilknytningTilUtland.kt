package no.nav.familie.ks.søknadkontrakt

data class TilknytningTilUtland @JsonCreator constructor (
    var annenForelderBoddEllerJobbetINorgeMinstFemAar: TilknytningTilUtlandVerdier? = null,
    var annenForelderBoddEllerJobbetINorgeMinstFemAarForklaring: String? = null,
    var boddEllerJobbetINorgeMinstFemAar: TilknytningTilUtlandVerdier? = null,
    var boddEllerJobbetINorgeMinstFemAarForklaring: String? = null
)