package no.nav.familie.kontrakter.ks.søknad.testdata

import no.nav.familie.kontrakter.ks.søknad.Søknad
import no.nav.familie.kontrakter.ks.søknad.toSøknad
import tools.jackson.databind.ObjectMapper

class SøknadTestdata {
    companion object {
        val mapper: ObjectMapper = ObjectMapper()

        const val MOR_AKTØRID = "1300000000001"
        const val MOR_PERSONIDENT = "12345678901"

        const val FAR_AKTØRID = "1300000000002"
        const val FAR_PERSONIDENT = "12345678911"

        const val BARN_AKTØRID = "1300000000003"
        const val BARN_PERSONIDENT = "01101800033"

        const val UTENLANDSK_BARN_AKTØRID = "1300000000004"
        const val UTENLANDSK_BARN_PERSONIDENT = "01101800044"

        const val UTENLANDSK_MOR_AKTØRID = "1300000000005"
        const val UTENLANDSK_MOR_PERSONIDENT = "00000000005"

        const val UTENLANDSK_FAR_AKTØRID = "1300000000006"
        const val UTENLANDSK_FAR_PERSONIDENT = "00000000006"

        @JvmStatic
        fun norskFamilieUtenAnnenPartOgUtenBarnehageplass(): Søknad =
            hentSøknadFraFil("SøknadNorskFamilieUtenAnnenPartOgUtenBarnehageplass.json")

        @JvmStatic
        fun norskFamilieUtenBarnehageplass(): Søknad = hentSøknadFraFil("SøknadNorskFamilieUtenBarnehageplass.json")

        @JvmStatic
        fun norskFamilieUtenBarnehageplassFlerlinger(): Søknad = hentSøknadFraFil("SøknadNorskFamilieUtenBarnehageplassFlerlinger.json")

        @JvmStatic
        fun norskFamilieGradertBarnehageplass(): Søknad = hentSøknadFraFil("SøknadNorskFamilieGradertBarnehageplass.json")

        @JvmStatic
        fun norskFamilieMedBarnehageplass(): Søknad = hentSøknadFraFil("SøknadNorskFamilieMedBarnehageplass.json")

        @JvmStatic
        fun enForelderIUtlandUtenBarnehageplass(): Søknad = hentSøknadFraFil("SøknadEnForelderIUtlandUtenBarnehageplass.json")

        @JvmStatic
        fun utenlandskFamilieUtenBarnehageplass(): Søknad = hentSøknadFraFil("SøknadUtenlandskFamilieUtenBarnehageplass.json")

        @JvmStatic
        fun utenlandskFamilieMedBarnehageplass(): Søknad = hentSøknadFraFil("SøknadUtenlandskFamilieMedBarnehageplass.json")

        @JvmStatic
        fun tilknytningUtlandUtenBarnehageplass(): Søknad = hentSøknadFraFil("SøknadTilknytningUtlandUtenBarnehageplass.json")

        @JvmStatic
        fun utenlandskFamilieMedGradertBarnehageplass(): Søknad = hentSøknadFraFil("SøknadUtenlandskFamilieMedGradertBarnehage.json")

        private fun hentSøknadFraFil(filnavn: String): Søknad =
            this::class.java
                .getResource("/søknader/$filnavn")
                .readText()
                .toSøknad()
    }
}
