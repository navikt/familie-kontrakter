package no.nav.familie.kontrakter.ef.sak

import no.nav.familie.kontrakter.ef.søknad.SøknadMedVedlegg

data class SakRequest<T>(
    val søknad: SøknadMedVedlegg<T>,
    val saksnummer: String,
    val journalpostId: String,
)
