package no.nav.familie.kontrakter.ef.ettersending

import no.nav.familie.kontrakter.ef.søknad.Innsendingsdetaljer
import no.nav.familie.kontrakter.ef.søknad.Personalia
import no.nav.familie.kontrakter.ef.søknad.Søknadsfelt

data class Ettersending(val personalia: Søknadsfelt<Personalia>,
                        val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>
                      )
