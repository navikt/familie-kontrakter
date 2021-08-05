package no.nav.familie.kontrakter.ef.søknad

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.fail
import java.lang.Exception

internal class SøknadTypeTest {

    @Test
    fun `harDokumentasjonsbehov returnerer true for alle søknadstyper`() {
        assertTrue(SøknadType.harDokumentasjonsbehov(SøknadType.OVERGANGSSTØNAD.toString()))
        assertTrue(SøknadType.harDokumentasjonsbehov(SøknadType.SKOLEPENGER.toString()))
        assertTrue(SøknadType.harDokumentasjonsbehov(SøknadType.BARNETILSYN.toString()))
    }

    @Test
    fun `harDokumentasjonsbehov returnerer false for arbeidssøkerskjema`() {
        assertFalse(SøknadType.harDokumentasjonsbehov(SøknadType.OVERGANGSSTØNAD_ARBEIDSSØKER.toString()))
    }

    @Test
    fun `harDokumentasjonsbehov kaster feil ved ukjent søknadstype`() {
        try {
            SøknadType.harDokumentasjonsbehov("finnesIkke")
        } catch(exception: Exception) {
            return
        }
        fail("Skal ikke komme hit")
    }

}