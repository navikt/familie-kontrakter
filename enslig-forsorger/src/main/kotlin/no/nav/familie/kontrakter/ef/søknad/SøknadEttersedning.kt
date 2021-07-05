package no.nav.familie.kontrakter.ef.søknad

data class SøknadEttersending(  val personalia: Søknadsfelt<Personalia>,
                                val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>
                            )