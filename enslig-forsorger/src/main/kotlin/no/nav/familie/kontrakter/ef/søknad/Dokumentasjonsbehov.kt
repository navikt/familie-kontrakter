package no.nav.familie.kontrakter.ef.søknad

data class Dokumentasjonsbehov(
    val label: String,
    val id: String,
    val harSendtInn: Boolean,
    val opplastedeVedlegg: List<Dokument> = emptyList()
)
