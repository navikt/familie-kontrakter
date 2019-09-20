package no.nav.familie.ks.søknadkontrakt

data class TilknytningTilUtland(
    var annenForelderBoddEllerJobbetINorgeMinstFemAar: TilknytningTilUtlandVerdier,
    var annenForelderBoddEllerJobbetINorgeMinstFemAarForklaring: String,
    var boddEllerJobbetINorgeMinstFemAar: TilknytningTilUtlandVerdier,
    var boddEllerJobbetINorgeMinstFemAarForklaring: String
)