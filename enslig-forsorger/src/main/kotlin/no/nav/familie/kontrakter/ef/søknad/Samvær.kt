@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Samvær(val spørsmålAvtaleOmDeltBosted: Spørsmål<Boolean>,
                  val avtaleOmDeltBosted: Dokument? = null,
                  val skalAnnenForelderHaSamvær: Spørsmål<String>? = null,
                  val harDereSkriftligAvtaleOmSamvær: Spørsmål<String>? = null,
                  val samværsavtale: Dokument? = null,
                  val hvordanPraktiseresSamværet: Spørsmål<String>? = null,
                  val borAnnenForelderISammeHus: Spørsmål<Boolean>? = null,
                  val harDereTidligereBoddSammen: Spørsmål<Boolean>? = null,
                  val nårFlyttetDereFraHverandre: Spørsmål<LocalDate>? = null,
                  val erklæringOmSamlivsbrudd: Dokument? = null,
                  val hvorMyeErDuSammenMedAnnenForelder: Spørsmål<String>? = null,
                  val beskrivSamværUtenBarn: Spørsmål<String>? = null)
