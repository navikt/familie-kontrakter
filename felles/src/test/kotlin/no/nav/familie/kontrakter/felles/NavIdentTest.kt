package no.nav.familie.kontrakter.felles

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class NavIdentTest {
    @Test
    fun `skal kaste exception om ident er blank`() {
        // Act & assert
        val exception =
            assertThrows<IllegalArgumentException> {
                NavIdent("")
            }
        assertEquals(exception.message, "Ident kan ikke være tom")
    }
}
