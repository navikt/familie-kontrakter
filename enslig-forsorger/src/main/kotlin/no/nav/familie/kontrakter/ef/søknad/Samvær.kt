@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Samvær(val spørsmålAvtaleOmDeltBosted: Felt<Boolean>,
                  val avtaleOmDeltBosted: Felt<Dokument>?,
                  val skalAnnenForelderHaSamvær: Felt<String>?,
                  val harDereSkriftligAvtaleOmSamvær: Felt<String>?,
                  val samværsavtale: Felt<Dokument>?,
                  val hvordanPraktiseresSamværet: Felt<String>?,
                  val borAnnenForelderISammeHus: Felt<Boolean>?,
                  val hardereTidligereBoddSammen: Felt<Boolean>?,
                  val nårFlyttetDereFraHverandre: Felt<LocalDate>?,
                  val erklæringOmSamlivsbrudd: Felt<Dokument>?,
                  val hvorMyeErDuSammenMedAnnenForelder: Felt<String>?,
                  val beskrivSamværUtenBarn: Felt<String>?)
