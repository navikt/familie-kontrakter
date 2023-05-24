package no.nav.familie.kontrakter.ef.søknad

data class TidligereUtdanning(
    val linjeKursGrad: Søknadsfelt<String>,
    val nårVarSkalDuVæreElevStudent: Søknadsfelt<MånedÅrPeriode>,
)

data class GjeldendeUtdanning(
    val linjeKursGrad: Søknadsfelt<String>,
    val nårVarSkalDuVæreElevStudent: Søknadsfelt<Datoperiode>,
)
