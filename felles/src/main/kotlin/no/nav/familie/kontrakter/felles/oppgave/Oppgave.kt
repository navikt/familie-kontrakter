package no.nav.familie.kontrakter.felles.oppgave

import javax.validation.constraints.Pattern

data class Oppgave(
    @field:Pattern(regexp = "[0-9]{13}")
    val aktorId: String,
    val journalpostId: String,
    val eksisterendeOppgaveId: String?,
    val beskrivelse: String,
    val tema: Tema
)
