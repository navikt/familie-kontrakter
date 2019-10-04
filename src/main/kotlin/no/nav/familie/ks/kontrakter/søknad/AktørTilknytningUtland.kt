package no.nav.familie.ks.kontrakter.søknad

import javax.validation.constraints.Pattern

data class AktørTilknytningUtland(
    @Pattern(regexp = "[0-9]{13}")
    val aktørId: String?,
    val fødselsnummer: String,
    val boddEllerJobbetINorgeMinstFemAar: TilknytningTilUtlandVerdier,
    val boddEllerJobbetINorgeMinstFemAarForklaring: String
)