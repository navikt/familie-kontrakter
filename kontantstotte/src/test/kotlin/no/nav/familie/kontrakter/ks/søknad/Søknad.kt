package no.nav.familie.kontrakter.ks.søknad

import no.nav.familie.kontrakter.ks.søknad.testdata.SøknadTestdata
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

    @Test
    fun test_uthenting_av_testdata_uten_annen_part() {
        val søknad = SøknadTestdata.norskFamilieUtenAnnenPartOgUtenBarnehageplass()

        assertNotNull(søknad)
        assertEquals(søknad.søkerFødselsnummer, SøknadTestdata.morPersonident)
    }

    @Test
    fun test_uthenting_av_testdata_flerlinger() {
        val søknad = SøknadTestdata.norskFamilieUtenBarnehageplassFlerlinger()

        assertNotNull(søknad)
        assertEquals(søknad.oppgittFamilieforhold.barna.size, 2)
    }
}