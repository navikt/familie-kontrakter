package no.nav.familie.kontrakter.ef.søknad

data class Ettersending(  val personalia: Søknadsfelt<Personalia>,
                          val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>
                      )
