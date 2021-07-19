package no.nav.familie.kontrakter.ef.ettersending

import no.nav.familie.kontrakter.ef.søknad.Innsendingsdetaljer
import no.nav.familie.kontrakter.ef.søknad.Søknadsfelt

data class Ettersending(val fnr: String,
                        val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>
                      )
