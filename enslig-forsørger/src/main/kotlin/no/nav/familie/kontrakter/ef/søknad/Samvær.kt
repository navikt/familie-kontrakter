package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Samvær(val spørsmålAvtaleOmDeltBosted: Spørsmål<Boolean>,
                  val avtaleOmDeltBosted: Dokument,
                  val skalAnnenForelderHaSamvær: Spørsmål<String>,
                  val harDereSkriftligAvtaleOmSamvær: Spørsmål<String>,
                  val samværsavtale: Dokument,
                  val hvordanPraktiseresSamværet: Spørsmål<String>,
                  val borAnnenForelderISammeHus: Spørsmål<Boolean>,
                  val hardereTidligereBoddSammen: Spørsmål<Boolean>,
                  val nårFlyttetDereFraHverandre: Spørsmål<LocalDate>,
                  val erklæringOmSamlivsbrudd: Dokument,
                  val hvorMyeErDuSammenMedAnnenForelder: Spørsmål<String>,
                  val beskrivSamværUtenBarn: Spørsmål<String>)
