package no.nav.familie.kontrakter.felles.oppgave

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class OppgaveTest {

    @Test
    internal fun `Skal kunne legge til og hente ut metadata `() {
        val oppgave = Oppgave()
        oppgave.leggTilMetadata("blankett", "true")
        assertEquals(oppgave.hentMetadata("blankett"), "true")
    }

    @Test
    internal fun `Skal kunne legge til og hente ut metadata som json `() {
        val oppgave = Oppgave()
        oppgave.leggTilMetadata("blankett", "true")
        val mapper: ObjectMapper = ObjectMapper()
        val oppgaveSerialisert = mapper.writeValueAsString(oppgave)
        val oppgaveDeserialisert: Oppgave = mapper.readValue(oppgaveSerialisert)

        assertEquals(oppgaveSerialisert.contains("blankett"), true)
        assertEquals(oppgaveDeserialisert.hentMetadata("blankett"), "true")
        assertEquals(oppgave.hentMetadata("blankett"), "true")
    }
}