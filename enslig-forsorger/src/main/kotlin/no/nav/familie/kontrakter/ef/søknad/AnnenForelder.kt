package no.nav.familie.kontrakter.ef.søknad

data class AnnenForelder(val kanIkkeOppgiAnnenForelderFar: Søknadsfelt<Boolean>?,
                         val ikkeOppgittAnnenForelderBegrunnelse: Søknadsfelt<String>? = null,
                         val bosattNorge: Søknadsfelt<Boolean>? = null,
                         val land: Søknadsfelt<String>? = null,
                         val person: Søknadsfelt<PersonMinimum>? = null)

