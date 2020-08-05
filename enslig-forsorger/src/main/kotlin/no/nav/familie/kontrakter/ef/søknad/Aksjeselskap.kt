package no.nav.familie.kontrakter.ef.søknad

class Aksjeselskap(val navn: Søknadsfelt<String>,
                   val arbeidsmengde: Søknadsfelt<Int>? = null)

/**
 * Arbeidsmengde skal ikke fylles ut av Barnetilsyn
 */
