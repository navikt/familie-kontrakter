package no.nav.familie.kontrakter.ef.søknad

data class AnnenForelder(val kanIkkeOppgiAnnenForelderFar: Søknadsfelt<Boolean>? = null,
                         val ikkeOppgittAnnenForelderBegrunnelse: Søknadsfelt<String>? = null,
                         val bosattNorge: Søknadsfelt<Boolean>? = null,
                         val person: Søknadsfelt<PersonMinimum>? = null,
                         val adresse: Søknadsfelt<Adresse>? = null)

