package no.nav.familie.kontrakter.ef.ettersending

import no.nav.familie.kontrakter.ef.søknad.Dokumentasjonsbehov

data class EttersendingForSøknad(val søknadId: String,
                                 val dokumentasjonsbehov: List<Dokumentasjonsbehov>,
                                 val innsending: List<Innsending>)