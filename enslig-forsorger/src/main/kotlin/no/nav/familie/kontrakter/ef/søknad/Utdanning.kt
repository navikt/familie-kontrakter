package no.nav.familie.kontrakter.ef.søknad

data class Utdanning(val linjeKursGrad: Søknadsfelt<String>,
                     val nårVarSkalDuVæreElevStudent: Søknadsfelt<Periode>)
