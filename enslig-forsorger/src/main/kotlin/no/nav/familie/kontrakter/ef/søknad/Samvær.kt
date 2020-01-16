@file:ContextualSerialization(LocalDate::class)
package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Samvær(val spørsmålAvtaleOmDeltBosted: Spørsmål<Boolean>,
                  val avtaleOmDeltBosted: Dokument?,
                  val skalAnnenForelderHaSamvær: Spørsmål<String>?,
                  val harDereSkriftligAvtaleOmSamvær: Spørsmål<String>?,
                  val samværsavtale: Dokument?,
                  val hvordanPraktiseresSamværet: Spørsmål<String>?,
                  val borAnnenForelderISammeHus: Spørsmål<Boolean>?,
                  val hardereTidligereBoddSammen: Spørsmål<Boolean>?,
                  val nårFlyttetDereFraHverandre: Spørsmål<LocalDate>?,
                  val erklæringOmSamlivsbrudd: Dokument?,
                  val hvorMyeErDuSammenMedAnnenForelder: Spørsmål<String>?,
                  val beskrivSamværUtenBarn: Spørsmål<String>?)
