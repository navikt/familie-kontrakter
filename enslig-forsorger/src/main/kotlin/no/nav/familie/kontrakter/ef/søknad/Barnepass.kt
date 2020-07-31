package no.nav.familie.kontrakter.ef.søknad

data class Barnepass(val årsakBarnepass: Søknadsfelt<String>? = null,
                     val barnepassordninger: Søknadsfelt<List<BarnepassOrdning>>)

data class BarnepassOrdning(val hvaSlagsBarnepassOrdning: Søknadsfelt<String>,
                            val navn: Søknadsfelt<String>,
                            val periode: Søknadsfelt<Periode>,
                            val belop: Søknadsfelt<Double>)
