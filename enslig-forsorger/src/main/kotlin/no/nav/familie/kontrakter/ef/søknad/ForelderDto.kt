package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class ForelderDto(val kanIkkeOppgiAnnenForelderFar: Spørsmål<Boolean>,
                       val ikkeOppgittAnnenForelderBegrunnelse: Spørsmål<String>?,
                       val bosattNorge: Spørsmål<Boolean>?,
                       val personalia: PersonMinimumDto?)

