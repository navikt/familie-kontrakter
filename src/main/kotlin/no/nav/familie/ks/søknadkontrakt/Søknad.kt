package no.nav.familie.ks.søknadkontrakt

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Søknad @JsonCreator constructor (

        @JsonProperty("innsendtTidspunkt")
        val innsendtTidspunkt: LocalDateTime,

        @JsonProperty("gjenopptakelseNaturalytelser")
        val aktørerArbeidYtelseIUtlandet: Set<AktørArbeidYtelseUtland>,

        @JsonProperty("oppgittErklæring")
        val oppgittErklæring: OppgittErklæring
)