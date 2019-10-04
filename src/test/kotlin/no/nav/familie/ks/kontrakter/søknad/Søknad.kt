package no.nav.familie.ks.kontrakter.søknad

import no.nav.familie.ks.kontrakter.søknad.testdata.SøknadTestdata
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SøknadKontrakt {

    @Test
    fun test_uthenting_av_testdata() {
        val søknad = SøknadTestdata.norskFamilieUtenBarnehageplass()

        assertNotNull(søknad)
        assertEquals(søknad.søkerFødselsnummer, SøknadTestdata.morPersonident)
    }
}