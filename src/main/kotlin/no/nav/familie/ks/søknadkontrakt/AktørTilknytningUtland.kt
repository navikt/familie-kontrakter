package no.nav.familie.ks.søknadkontrakt

data class AktørTilknytningUtland(
    val aktørId: String,
    val tilknytningTilUtland: TilknytningTilUtlandVerdier,
    val tilknytningTilUtlandForklaring: String
)