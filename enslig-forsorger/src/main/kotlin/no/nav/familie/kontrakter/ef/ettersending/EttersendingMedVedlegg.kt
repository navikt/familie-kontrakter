package no.nav.familie.kontrakter.ef.ettersending

import no.nav.familie.kontrakter.ef.søknad.Dokumentasjonsbehov
import no.nav.familie.kontrakter.ef.søknad.Vedlegg

data class EttersendingMedVedlegg(val ettersending: Ettersending,
                                     val vedlegg: List<Vedlegg> = emptyList(),
                                     val dokumentasjonsbehov: List<Dokumentasjonsbehov> = emptyList())

