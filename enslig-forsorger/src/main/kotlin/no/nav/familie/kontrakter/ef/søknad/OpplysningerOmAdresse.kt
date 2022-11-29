package no.nav.familie.kontrakter.ef.søknad

data class OpplysningerOmAdresse(
    val søkerBorPåRegistrertAdresse: Søknadsfelt<Boolean>? = null,
    val harMeldtFlytteendring: Søknadsfelt<Boolean>? = null,
    val dokumentasjonFlytteendring: Søknadsfelt<Dokumentasjon>?
)
