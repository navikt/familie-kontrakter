package no.nav.familie.kontrakter.ef.sak

import no.nav.familie.kontrakter.ef.søknad.Søknad

data class Sak(val søknad: Søknad,
               val saksnummer: String,
               val journalpostId: String)
