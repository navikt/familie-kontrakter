package no.nav.familie.kontrakter.ef.søknad

data class SøknadMedVedlegg<T>(
    val søknad: T,
    val vedlegg: List<Vedlegg>,
    val dokumentasjonsbehov: List<Dokumentasjonsbehov> = emptyList(),
    val behandleINySaksbehandling: Boolean = false,
    val erSelvstendigNæringsdrivende: Boolean = false,
    val harSærligTilsynskrevendeBarn: Boolean = false
)
