package no.nav.familie.kontrakter.ef.søknad

/**
 * Arbeidsmengde skal ikke fylles ut av Barnetilsyn
 */
class Aksjeselskap(
    val navn: Søknadsfelt<String>,
    val arbeidsmengde: Søknadsfelt<Int>? = null,
)
