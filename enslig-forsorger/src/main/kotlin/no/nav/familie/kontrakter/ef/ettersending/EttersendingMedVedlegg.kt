package no.nav.familie.kontrakter.ef.ettersending

import no.nav.familie.kontrakter.ef.søknad.Dokumentasjonsbehov
import no.nav.familie.kontrakter.ef.søknad.Vedlegg

data class EttersendingMedVedlegg<T>(val ettersending: T,
                                     val vedlegg: List<Vedlegg>,
                                     val dokumentasjonsbehov: List<Dokumentasjonsbehov> = emptyList(),
                                     val behandleINySaksbehandling: Boolean = false)
