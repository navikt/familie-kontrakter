package no.nav.familie.kontrakter.ef.søknad

data class AnnenForelder(
    val ikkeOppgittAnnenForelderBegrunnelse: Søknadsfelt<String>? = null,
    val person: Søknadsfelt<PersonMinimum>? = null,
    val bosattNorge: Søknadsfelt<Boolean>? = null,
    val land: Søknadsfelt<String>? = null,
    val erKopiert: Boolean? = null,
)
