package no.nav.familie.kontrakter.ef.søknad

data class Utdanning(val linjeKursGrad: Søknadsfelt<String>,
                     val periode: Søknadsfelt<Periode>)
