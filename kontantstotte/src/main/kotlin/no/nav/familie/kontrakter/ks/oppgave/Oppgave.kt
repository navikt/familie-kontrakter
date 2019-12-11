package no.nav.familie.kontrakter.ks.oppgave

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.objectMapper
import javax.validation.constraints.Pattern

data class Oppgave(
    @field:Pattern(regexp = "[0-9]{13}")
    val aktorId: String,
    val journalpostId: String,
    val eksisterendeOppgaveId: String?,
    val beskrivelse: String
)

fun Oppgave.toJson(): String = objectMapper.writeValueAsString(this)
fun String.toOppgave(): Oppgave = objectMapper.readValue(this)
