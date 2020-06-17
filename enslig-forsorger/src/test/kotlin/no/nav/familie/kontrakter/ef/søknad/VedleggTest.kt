package no.nav.familie.kontrakter.ef.søknad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNotEquals

internal class VedleggTest {

    @Test
    internal fun `2 vedlegg med ulike innehold er ulike`() {
        assertNotEquals(Vedlegg("id", "navn", "tittel", byteArrayOf(12)),
                     Vedlegg("id", "navn", "tittel", byteArrayOf(13)))
    }

    @Test
    internal fun `2 vedlegg med samme innehold er like`() {
        assertEquals(Vedlegg("id", "navn", "tittel", byteArrayOf(12)),
                     Vedlegg("id", "navn", "tittel", byteArrayOf(12)))
    }
}
