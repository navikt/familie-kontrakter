package no.nav.familie.kontrakter.felles

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OrganisasjonsnummerTest {
    @Test
    fun `skal tillate ekte organisasjonsnummer`() {
        Organisasjonsnummer("803379653")
        Organisasjonsnummer("861827356")
        Organisasjonsnummer("803379653")
    }

    @Test
    fun `skal tillate syntetisk organisasjonsnummer`() {
        Organisasjonsnummer("214251892")
        Organisasjonsnummer("210707832")
        Organisasjonsnummer("310287849")
    }

    @Test
    fun `skal kaste feil ved ugyldig organisasjonsnummer`() {
        // For kort
        val exception1 = assertThrows<IllegalStateException> { Organisasjonsnummer("123") }
        assertEquals("Ugyldig organisasjonsnummer: 123", exception1.message)

        // Ikke tall
        val exception2 = assertThrows<IllegalStateException> { Organisasjonsnummer("ikke et tall") }
        assertEquals("Ugyldig organisasjonsnummer: ikke et tall", exception2.message)

        // Feil kontrollsiffer
        val exception3 = assertThrows<IllegalStateException> { Organisasjonsnummer("987654321") }
        assertEquals("Ugyldig organisasjonsnummer: 987654321", exception3.message)
    }

    @Test
    fun `erSyntetisk skal returnere riktig verdi`() {
        val ekteOrgNr = Organisasjonsnummer("803379653")
        val syntetiskOrgNr1 = Organisasjonsnummer("214251892")
        val syntetiskOrgNr2 = Organisasjonsnummer("310287849")

        assertEquals(false, ekteOrgNr.erSyntetisk)
        assertEquals(true, syntetiskOrgNr1.erSyntetisk)
        assertEquals(true, syntetiskOrgNr2.erSyntetisk)
    }

    @Test
    fun `toString skal formatere organisasjonsnummer riktig`() {
        assertEquals("803 379 653", Organisasjonsnummer("803379653").toString())
    }
}
