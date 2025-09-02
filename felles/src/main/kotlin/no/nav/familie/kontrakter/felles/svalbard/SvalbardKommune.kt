package no.nav.familie.kontrakter.felles.svalbard

enum class SvalbardKommune(
    val kommunenummer: String,
) {
    SVALBARD("2100"),
}

fun erKommunePåSvalbard(kommunenummer: String): Boolean = SvalbardKommune.entries.any { it.kommunenummer == kommunenummer }
