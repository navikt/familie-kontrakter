package no.nav.familie.kontrakter.ef.søknad

data class Søknadsfelt<T>(val label: String, val verdi: T, val alternativer: List<String>? = null, val svarId: T? = null)

data class EnumTekstverdiMedSvarId(val verdi: String, val svarId: String)
