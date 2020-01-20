package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Forelder(val kanIkkeOppgiAnnenForelderFar: Felt<Boolean>,
                    val ikkeOppgittAnnenForelderBegrunnelse: Felt<String>? = null,
                    val bosattNorge: Felt<Boolean>? = null,
                    val personalia: Felt<PersonMinimum>? = null)

