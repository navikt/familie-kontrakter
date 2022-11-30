package no.nav.familie.kontrakter.ef.søknad

data class Adresseopplysninger(
    val søkerBorPåRegistrertAdresse: Søknadsfelt<Boolean>? = null,
    val harMeldtAdresseendring: Søknadsfelt<Boolean>? = null,
    val dokumentasjonAdresseendring: Søknadsfelt<Dokumentasjon>?
)
