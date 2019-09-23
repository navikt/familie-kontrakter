package no.nav.familie.ks.søknadkontrakt

import javax.validation.constraints.Pattern

data class AktørTilknytningUtland(
        @Pattern(regexp = "[0-9]{13}")
        val aktørId: String,
        val boddEllerJobbetINorgeMinstFemAar: TilknytningTilUtlandVerdier,
        val boddEllerJobbetINorgeMinstFemAarForklaring: String
)