package no.nav.familie.kontrakter.ef.søknad

data class Dokumentasjon(
    val harSendtInnTidligere: Søknadsfelt<Boolean>,
    val dokumenter: List<Dokument>,
)
