package no.nav.familie.ks.kontrakter.oppgave

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.ks.kontrakter.Kontrakt
import no.nav.familie.ks.kontrakter.objectMapper
import javax.validation.constraints.Pattern

data class Oppgave(
    @field:Pattern(regexp = "[0-9]{13}")
    val aktorId: String,
    val journalpostId: String,
    val eksisterendeOppgaveId: String?,
    val beskrivelse: String
) : Kontrakt

fun Oppgave.toJson(): String = objectMapper.writeValueAsString(this)
fun String.toOppgave(): Oppgave = objectMapper.readValue(this)
