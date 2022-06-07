package no.nav.familie.kontrakter.ef.sak

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DokumentBrevkodeTest {

    @Test
    internal fun `skal returnere riktig element for gyldig brevkode`() {
        Assertions.assertEquals(DokumentBrevkode.OVERGANGSSTØNAD, DokumentBrevkode.fraBrevkode("NAV 15-00.01"))
        Assertions.assertEquals(DokumentBrevkode.BARNETILSYN, DokumentBrevkode.fraBrevkode("NAV 15-00.02"))
        Assertions.assertEquals(DokumentBrevkode.SKOLEPENGER, DokumentBrevkode.fraBrevkode("NAV 15-00.04"))
    }

    @Test
    internal fun `skal kaste feil dersom brevkode er ugyldig`() {
        Assertions.assertThrows(NoSuchElementException::class.java) { DokumentBrevkode.fraBrevkode("NAV 15-00.08") }
        Assertions.assertThrows(NoSuchElementException::class.java) { DokumentBrevkode.fraBrevkode("") }
        Assertions.assertThrows(NoSuchElementException::class.java) { DokumentBrevkode.fraBrevkode(null) }
    }

    @Test
    internal fun `skal verifisere at brevkode er gyldig`() {
        Assertions.assertTrue(DokumentBrevkode.erGyldigBrevkode("NAV 15-00.01"))
        Assertions.assertTrue(DokumentBrevkode.erGyldigBrevkode("NAV 15-00.02"))
        Assertions.assertTrue(DokumentBrevkode.erGyldigBrevkode("NAV 15-00.04"))
        Assertions.assertFalse(DokumentBrevkode.erGyldigBrevkode("NAV 15-00.08"))
        Assertions.assertFalse(DokumentBrevkode.erGyldigBrevkode(""))
        Assertions.assertFalse(DokumentBrevkode.erGyldigBrevkode(null))
    }
}
