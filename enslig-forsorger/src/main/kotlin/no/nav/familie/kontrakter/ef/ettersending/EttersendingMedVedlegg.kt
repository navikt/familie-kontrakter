package no.nav.familie.kontrakter.ef.ettersending

import no.nav.familie.kontrakter.ef.søknad.Dokumentasjonsbehov
import no.nav.familie.kontrakter.ef.søknad.Innsendingsdetaljer
import no.nav.familie.kontrakter.ef.søknad.Søknadsfelt
import no.nav.familie.kontrakter.ef.søknad.Vedlegg

data class EttersendingMedVedlegg(val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>,
                                  val vedlegg: List<Vedlegg> = emptyList(),
                                  val dokumentasjonsbehov: List<Dokumentasjonsbehov> = emptyList(),
                                  val ettersending: EttersendingDto)

