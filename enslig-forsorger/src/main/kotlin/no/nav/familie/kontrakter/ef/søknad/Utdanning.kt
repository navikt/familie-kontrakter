package no.nav.familie.kontrakter.ef.søknad

data class Utdanning<T>(val linjeKursGrad: Søknadsfelt<String>,
                     val nårVarSkalDuVæreElevStudent: Søknadsfelt<T>)
