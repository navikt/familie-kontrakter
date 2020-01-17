package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Forelder(val kanIkkeOppgiAnnenForelderFar: Spørsmål<Boolean>,
                    val ikkeOppgittAnnenForelderBegrunnelse: Spørsmål<String>? = null,
                    val bosattNorge: Spørsmål<Boolean>? = null,
                    val personalia: PersonMinimum? = null)

