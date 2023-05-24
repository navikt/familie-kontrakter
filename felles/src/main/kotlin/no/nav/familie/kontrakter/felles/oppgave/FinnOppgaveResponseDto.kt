package no.nav.familie.kontrakter.felles.oppgave

data class FinnOppgaveResponseDto(
    val antallTreffTotalt: Long,
    val oppgaver: List<Oppgave>,
)
