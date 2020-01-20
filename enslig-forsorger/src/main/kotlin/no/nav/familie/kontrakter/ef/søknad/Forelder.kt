package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Forelder(val kanIkkeOppgiAnnenForelderFar: Felt<Boolean>,
                    val ikkeOppgittAnnenForelderBegrunnelse: Felt<String>?,
                    val bosattNorge: Felt<Boolean>?,
                    val personalia: Felt<PersonMinimum>?)

