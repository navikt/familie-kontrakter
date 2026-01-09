package no.nav.familie.kontrakter.ks.søknad

import jakarta.validation.constraints.Pattern
import no.nav.familie.kontrakter.felles.jsonMapper
import tools.jackson.module.kotlin.readValue
import java.time.LocalDateTime

data class Søknad(
    @field:Pattern(regexp = "[0-9]{11}")
    val søkerFødselsnummer: String,
    val språk: String?,
    val oppgittAnnenPartFødselsnummer: String?,
    val innsendtTidspunkt: LocalDateTime?,
    val oppgittFamilieforhold: OppgittFamilieforhold,
    val oppgittUtlandsTilknytning: OppgittUtlandsTilknytning,
    val oppgittErklæring: OppgittErklæring,
)

fun String.toSøknad(): Søknad = jsonMapper.readValue(this)

fun Søknad.toJson(): String = jsonMapper.writeValueAsString(this)
