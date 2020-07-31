package no.nav.familie.kontrakter.ef.søknad

data class SøknadMedVedlegg<T>(val søknad: T, val vedlegg: List<Vedlegg>)
