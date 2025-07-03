package no.nav.familie.kontrakter.ks.søknad

import com.fasterxml.jackson.module.kotlin.readValue
import jakarta.validation.constraints.Pattern
import no.nav.familie.kontrakter.felles.objectMapper
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

fun String.toSøknad(): Søknad = objectMapper.readValue(this)

fun Søknad.toJson(): String = objectMapper.writeValueAsString(this)
