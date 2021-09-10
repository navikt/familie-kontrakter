package no.nav.familie.kontrakter.ef.ettersending

import no.nav.familie.kontrakter.ef.felles.StønadType
import no.nav.familie.kontrakter.ef.søknad.Vedlegg
import java.time.LocalDate
import java.time.LocalDateTime

data class EttersendelseDto(val dokumentasjonsbehov: List<Dokumentasjonsbehov>,
                            val fnr: String
)

data class Dokumentasjonsbehov(val id: String,
                               val søknadsdata: SøknadMetadata? = null,
                               val dokumenttype: String,
                               val beskrivelse: String,
                               val stønadType: StønadType,
                               val innsendingstidspunkt: LocalDateTime? = null,
                               val vedlegg: List<Vedlegg>
)

data class SøknadMetadata(val søknadId: String,
                          val søknadsdato: LocalDate,
                          val dokumentasjonsbehovId: String,
                          val harSendtInnTidligere: Boolean
)