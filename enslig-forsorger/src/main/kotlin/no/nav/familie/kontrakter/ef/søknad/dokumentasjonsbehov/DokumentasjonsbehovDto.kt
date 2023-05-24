package no.nav.familie.kontrakter.ef.søknad.dokumentasjonsbehov

import no.nav.familie.kontrakter.ef.søknad.Dokumentasjonsbehov
import no.nav.familie.kontrakter.ef.søknad.SøknadType
import java.time.LocalDateTime

data class DokumentasjonsbehovDto(
    val dokumentasjonsbehov: List<Dokumentasjonsbehov>,
    val innsendingstidspunkt: LocalDateTime,
    val søknadType: SøknadType,
    val personIdent: String,
)
