package no.nav.familie.kontrakter.ba.svalbardtillegg

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class SvalbardKommuneTest {
    @Nested
    inner class ErSvalbardKommune {
        @Test
        fun `skal returnere true dersom kommunenummer samsvarer med en av kommunene på Svalbard`() {
            // Act & Assert
            val erKommunePåSvalbard = erKommunePåSvalbard("2100")

            assertTrue(erKommunePåSvalbard)
        }

        @Test
        fun `skal returnere false dersom kommunenummer ikke samsvarer med en av kommunene på Svalbard`() {
            // Act & Assert
            val erKommunePåSvalbard = erKommunePåSvalbard("1234")

            assertFalse(erKommunePåSvalbard)
        }
    }
}
