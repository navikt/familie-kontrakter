package no.nav.familie.kontrakter.ef.søknad

data class Ettersending(  val fnr: String,
                          val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>
                      )
