package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Forelder(val kanIkkeOppgiAnnenForelderFar: Søknadsfelt<Boolean>,
                    val ikkeOppgittAnnenForelderBegrunnelse: Søknadsfelt<String>? = null,
                    val bosattNorge: Søknadsfelt<Boolean>? = null,
                    val person: Søknadsfelt<PersonMinimum>? = null,
                    val adresse: Søknadsfelt<Adresse>? = null)

