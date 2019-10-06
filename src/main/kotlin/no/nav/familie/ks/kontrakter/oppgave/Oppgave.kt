package no.nav.familie.ks.kontrakter.oppgave

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.ks.kontrakter.Kontrakt
import no.nav.familie.ks.kontrakter.objectMapper
import javax.validation.constraints.Pattern

data class Oppgave(
    @field:Pattern(regexp = "[0-9]{11}")
    val fnr: String,
    val gosysSakId: String,
    val eksisterendeOppgaveId: String?,
    val behandlendeEnhetId: String,
    val beskrivelse: String,
    val behandlingsfristDager: Int = 0
) : Kontrakt

fun Oppgave.toJson(): String = objectMapper.writeValueAsString(this)
fun String.toOppgave(): Oppgave = objectMapper.readValue(this)
