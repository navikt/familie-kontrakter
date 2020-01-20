@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Samvær(val spørsmålAvtaleOmDeltBosted: Felt<Boolean>,
                  val avtaleOmDeltBosted: Felt<Dokument>? = null,
                  val skalAnnenForelderHaSamvær: Felt<String>? = null,
                  val harDereSkriftligAvtaleOmSamvær: Felt<String>? = null,
                  val samværsavtale: Felt<Dokument>? = null,
                  val hvordanPraktiseresSamværet: Felt<String>? = null,
                  val borAnnenForelderISammeHus: Felt<Boolean>? = null,
                  val harDereTidligereBoddSammen: Felt<Boolean>? = null,
                  val nårFlyttetDereFraHverandre: Felt<LocalDate>? = null,
                  val erklæringOmSamlivsbrudd: Felt<Dokument>? = null,
                  val hvorMyeErDuSammenMedAnnenForelder: Felt<String>? = null,
                  val beskrivSamværUtenBarn: Felt<String>? = null)
