package no.nav.familie.ks.kontrakter.søknad.testdata

import com.fasterxml.jackson.databind.ObjectMapper
import no.nav.familie.ks.kontrakter.søknad.Søknad
import no.nav.familie.ks.kontrakter.søknad.toSøknad

class SøknadTestdata {
    companion object {
        val mapper: ObjectMapper = ObjectMapper()

        const val morAktørId = "1300000000001"
        const val morPersonident = "12345678901"

        const val farAktørId = "1300000000002"
        const val farPersonident = "12345678911"

        const val barnAktørId = "1300000000003"
        const val barnPersonident = "00000000033"

        const val utenlandskBarnAktørId = "1300000000004"
        const val utenlandskBarnPersonident = "00000000004"

        const val utenlandskMorAktørId = "1300000000005"
        const val utenlandskMorPersonident = "00000000005"

        const val utenlandskFarAktørId = "1300000000006"
        const val utenlandskFarPersonident = "00000000006"

        @JvmStatic
        fun norskFamilieUtenAnnenPartOgUtenBarnehageplass(): Søknad {
            return hentSøknadFraFil("SøknadNorskFamilieUtenAnnenPartOgUtenBarnehageplass.json")
        }

        @JvmStatic
        fun norskFamilieUtenBarnehageplass(): Søknad {
            return hentSøknadFraFil("SøknadNorskFamilieUtenBarnehageplass.json")
        }

        @JvmStatic
        fun norskFamilieUtenBarnehageplassFlerlinger(): Søknad {
            return hentSøknadFraFil("SøknadNorskFamilieUtenBarnehageplassFlerlinger.json")
        }

        @JvmStatic
        fun norskFamilieGradertBarnehageplass(): Søknad {
            return hentSøknadFraFil("SøknadNorskFamilieGradertBarnehageplass.json")
        }

        @JvmStatic
        fun norskFamilieMedBarnehageplass(): Søknad {
            return hentSøknadFraFil("SøknadNorskFamilieMedBarnehageplass.json")
        }

        @JvmStatic
        fun enForelderIUtlandUtenBarnehageplass(): Søknad {
            return hentSøknadFraFil("SøknadEnForelderIUtlandUtenBarnehageplass.json")
        }

        @JvmStatic
        fun utenlandskFamilieUtenBarnehageplass(): Søknad {
            return hentSøknadFraFil("SøknadUtenlandskFamilieUtenBarnehageplass.json")
        }

        @JvmStatic
        fun utenlandskFamilieMedBarnehageplass(): Søknad {
            return hentSøknadFraFil("SøknadUtenlandskFamilieMedBarnehageplass.json")
        }

        @JvmStatic
        fun tilknytningUtlandUtenBarnehageplass(): Søknad {
            return hentSøknadFraFil("SøknadTilknytningUtlandUtenBarnehageplass.json")
        }

        @JvmStatic
        fun utenlandskFamilieMedGradertBarnehageplass(): Søknad {
            return hentSøknadFraFil("SøknadUtenlandskFamilieMedGradertBarnehage.json")
        }

        private fun hentSøknadFraFil(filnavn: String): Søknad {
            return this::class.java.getResource("/søknader/$filnavn").readText().toSøknad()
        }
    }
}