package no.nav.familie.kontrakter.ef.søknad

data class Dokumentasjonsbehov(val label: String,
                               val id: String, // Trenger vi denne? Denne er ju mappet til en tekst i frontend (label)
                               val harSendtInn: Boolean,
                               val opplastedeVedlegg: List<String> = emptyList())
