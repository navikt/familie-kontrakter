package no.nav.familie.kontrakter.ks.søknad

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.Kontrakt
import no.nav.familie.kontrakter.felles.objectMapper
import java.time.LocalDateTime
import javax.validation.constraints.Pattern

data class Søknad(
    @field:Pattern(regexp = "[0-9]{11}")
    val søkerFødselsnummer: String,
    val språk: String?,
    val oppgittAnnenPartFødselsnummer: String?,
    val innsendtTidspunkt: LocalDateTime?,
    val oppgittFamilieforhold: OppgittFamilieforhold,
    val oppgittUtlandsTilknytning: OppgittUtlandsTilknytning,
    val oppgittErklæring: OppgittErklæring
) : Kontrakt

fun String.toSøknad(): Søknad = objectMapper.readValue(this)

fun Søknad.toJson(): String = objectMapper.writeValueAsString(this)
