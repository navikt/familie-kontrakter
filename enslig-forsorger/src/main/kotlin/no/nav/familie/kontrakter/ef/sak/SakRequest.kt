package no.nav.familie.kontrakter.ef.sak

import no.nav.familie.kontrakter.ef.søknad.SøknadMedVedlegg

data class SakRequest(val søknad: SøknadMedVedlegg,
                      val saksnummer: String,
                      val journalpostId: String)
