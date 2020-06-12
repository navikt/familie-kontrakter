package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Samvær(val spørsmålAvtaleOmDeltBosted: Søknadsfelt<Boolean>,
                  val avtaleOmDeltBosted: Søknadsfelt<List<Dokument>>? = null,
                  val skalAnnenForelderHaSamvær: Søknadsfelt<String>? = null,
                  val harDereSkriftligAvtaleOmSamvær: Søknadsfelt<String>? = null,
                  val samværsavtale: Søknadsfelt<List<Dokument>>? = null,
                  val hvordanPraktiseresSamværet: Søknadsfelt<String>? = null,
                  val borAnnenForelderISammeHus: Søknadsfelt<String>? = null,
                  val borAnnenForelderISammeHusBeskrivelse: Søknadsfelt<String>? = null,
                  val harDereTidligereBoddSammen: Søknadsfelt<Boolean>? = null,
                  val nårFlyttetDereFraHverandre: Søknadsfelt<LocalDate>? = null,
                  val erklæringOmSamlivsbrudd: Søknadsfelt<List<Dokument>>? = null,
                  val hvorMyeErDuSammenMedAnnenForelder: Søknadsfelt<String>? = null,
                  val beskrivSamværUtenBarn: Søknadsfelt<String>? = null
)
