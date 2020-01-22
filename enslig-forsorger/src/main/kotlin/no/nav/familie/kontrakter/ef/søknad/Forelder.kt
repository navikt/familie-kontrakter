package no.nav.familie.kontrakter.ef.søknad

data class Forelder(val person: Søknadsfelt<PersonMinimum>? = null,
                    val kanIkkeOppgiAnnenForelderFar: Søknadsfelt<Boolean>,
                    val ikkeOppgittAnnenForelderBegrunnelse: Søknadsfelt<String>? = null,
                    val bosattNorge: Søknadsfelt<Boolean>? = null,
                    val adresse: Søknadsfelt<Adresse>? = null)

