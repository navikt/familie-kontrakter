package no.nav.familie.kontrakter.ba.svalbardtillegg

import no.nav.familie.kontrakter.ba.svalbardtillegg.SvalbardKommune.entries

enum class SvalbardKommune(
    val kommunenummer: String,
) {
    SVALBARD("2100"),
}

fun erKommunePåSvalbard(kommunenummer: String): Boolean = entries.any { it.kommunenummer == kommunenummer }
