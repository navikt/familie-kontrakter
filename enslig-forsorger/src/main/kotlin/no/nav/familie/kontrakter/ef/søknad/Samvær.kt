@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Samvær(val spørsmålAvtaleOmDeltBosted: Søknadsfelt<Boolean>,
                  val avtaleOmDeltBosted: Søknadsfelt<Dokument>? = null,
                  val skalAnnenForelderHaSamvær: Søknadsfelt<String>? = null,
                  val harDereSkriftligAvtaleOmSamvær: Søknadsfelt<String>? = null,
                  val samværsavtale: Søknadsfelt<Dokument>? = null,
                  val hvordanPraktiseresSamværet: Søknadsfelt<String>? = null,
                  val borAnnenForelderISammeHus: Søknadsfelt<Boolean>? = null,
                  val harDereTidligereBoddSammen: Søknadsfelt<Boolean>? = null,
                  val nårFlyttetDereFraHverandre: Søknadsfelt<LocalDate>? = null,
                  val erklæringOmSamlivsbrudd: Søknadsfelt<Dokument>? = null,
                  val hvorMyeErDuSammenMedAnnenForelder: Søknadsfelt<String>? = null,
                  val beskrivSamværUtenBarn: Søknadsfelt<String>? = null)
