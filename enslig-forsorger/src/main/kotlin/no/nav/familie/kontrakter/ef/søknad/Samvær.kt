package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Samvær(val spørsmålAvtaleOmDeltBosted: Søknadsfelt<Boolean>,
                  val avtaleOmDeltBosted: Søknadsfelt<Dokument>? = null,
                  val skalAnnenForelderHaSamvær: Søknadsfelt<String>? = null,
                  val harDereSkriftligAvtaleOmSamvær: Søknadsfelt<String>? = null,
                  val samværsavtale: Søknadsfelt<Dokument>? = null,
                  val hvordanPraktiseresSamværet: Søknadsfelt<String>? = null,
                  val borAnnenForelderISammeHus: Søknadsfelt<String>? = null,
                  val borAnnenForelderISammeHusBeskrivelse: Søknadsfelt<String>? = null,
                  val harDereTidligereBoddSammen: Søknadsfelt<Boolean>? = null,
                  val nårFlyttetDereFraHverandre: Søknadsfelt<LocalDate>? = null,
                  val erklæringOmSamlivsbrudd: Søknadsfelt<Dokument>? = null,
                  val hvorMyeErDuSammenMedAnnenForelder: Søknadsfelt<String>? = null,
                  val beskrivSamværUtenBarn: Søknadsfelt<String>? = null
)
