package no.nav.familie.kontrakter.ef.søknad

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SøknadTypeTest {

    @Test
    fun `harDokumentasjonsbehov returnerer true for alle søknadstyper`() {
        assertTrue(SøknadType.harDokumentasjonsbehov(SøknadType.OVERGANGSSTØNAD))
        assertTrue(SøknadType.harDokumentasjonsbehov(SøknadType.SKOLEPENGER))
        assertTrue(SøknadType.harDokumentasjonsbehov(SøknadType.BARNETILSYN))
    }

    @Test
    fun `harDokumentasjonsbehov returnerer false for arbeidssøkerskjema`() {
        assertFalse(SøknadType.harDokumentasjonsbehov(SøknadType.OVERGANGSSTØNAD_ARBEIDSSØKER))
    }
}