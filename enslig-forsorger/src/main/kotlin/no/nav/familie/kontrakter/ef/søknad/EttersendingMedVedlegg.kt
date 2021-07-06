package no.nav.familie.kontrakter.ef.søknad

data class EttersendingMedVedlegg<T>(val ettersending: T,
                               val vedlegg: List<Vedlegg>,
                               val dokumentasjonsbehov: List<Dokumentasjonsbehov> = emptyList(),
                               val behandleINySaksbehandling: Boolean = false)
