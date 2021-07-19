package no.nav.familie.kontrakter.ef.søknad

data class EttersendingMedVedlegg<T>(val ettersending: Ettersending,
                               val vedlegg: List<Vedlegg> = emptyList(),
                               val dokumentasjonsbehov: List<Dokumentasjonsbehov> = emptyList(),
                               val behandleINySaksbehandling: Boolean = false)
