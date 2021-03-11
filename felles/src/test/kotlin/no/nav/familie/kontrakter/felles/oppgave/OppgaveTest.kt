package no.nav.familie.kontrakter.felles.oppgave

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class OppgaveTest {

    @Test
    internal fun `Skal kunne legge til og hente ut metadata `() {
        val oppgave = Oppgave()
        oppgave.leggTilMetadata("blankett", "true")
        assertEquals(oppgave.hentMetadata("blankett"), "true")
    }
}