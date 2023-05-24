package no.nav.familie.kontrakter.ef.ettersending

import no.nav.familie.kontrakter.ef.søknad.dokumentasjonsbehov.DokumentasjonsbehovDto
import no.nav.familie.kontrakter.felles.ef.StønadType
import java.time.LocalDate

data class SøknadMedDokumentasjonsbehovDto(
    val søknadId: String,
    val stønadType: StønadType,
    val søknadDato: LocalDate,
    val dokumentasjonsbehov: DokumentasjonsbehovDto,
)
