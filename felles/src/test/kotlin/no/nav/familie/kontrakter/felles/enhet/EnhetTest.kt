package no.nav.familie.kontrakter.felles.enhet

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class EnhetTest {

    @Test
    fun `skal kunne opprette Enhet dersom enhetsnummer inneholder nøyaktig 4 siffer`() {
        // Act and assert
        assertDoesNotThrow { Enhet("1234")}
    }

    @Test
    fun `skal kaste feil ved opprettelse av Enhet dersom enhetsnummer inneholder mindre enn 4 siffer`() {
        // Act and assert
        val exception = assertThrows<IllegalArgumentException> { Enhet("123")}
        assertEquals("Enhetsnummer må være 4 siffer", exception.message)
    }

    @Test
    fun `skal kaste feil ved opprettelse av Enhet dersom enhetsnummer inneholder mer enn 4 siffer`() {
        // Act and assert
        val exception = assertThrows<IllegalArgumentException> { Enhet("12345")}
        assertEquals("Enhetsnummer må være 4 siffer", exception.message)
    }
}