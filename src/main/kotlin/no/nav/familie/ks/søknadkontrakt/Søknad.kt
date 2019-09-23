package no.nav.familie.ks.søknadkontrakt

import java.time.LocalDateTime
import javax.validation.constraints.Pattern

data class Søknad(
        @Pattern(regexp = "[0-9]{11}")
        val søkerFnr: String,
        val innsendtTidspunkt: LocalDateTime,
        val oppgittUtlandsTilknytning: OppgittUtlandsTilknytning,
        val oppgittErklæring: OppgittErklæring
)