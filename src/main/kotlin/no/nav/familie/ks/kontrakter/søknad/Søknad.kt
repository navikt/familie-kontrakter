package no.nav.familie.ks.kontrakter.søknad

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.ks.kontrakter.Kontrakt
import java.time.LocalDateTime
import javax.validation.constraints.Pattern

data class Søknad(
    @Pattern(regexp = "[0-9]{11}")
    val Språk: String?,
    val søkerFødselsnummer: String,
    val oppgittAnnenPartFødselsnummer: String?,
    val innsendtTidspunkt: LocalDateTime?,
    val oppgittFamilieforhold: OppgittFamilieforhold,
    val oppgittUtlandsTilknytning: OppgittUtlandsTilknytning,
    val oppgittErklæring: OppgittErklæring
) : Kontrakt() {
    fun Søknad.toJson(): String = objectMapper.writeValueAsString(this)
    fun String.toSøknad(): Søknad = objectMapper.readValue(this)
}