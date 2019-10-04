package no.nav.familie.ks.kontrakter.søknad.testdata

import com.fasterxml.jackson.databind.ObjectMapper
import no.nav.familie.ks.kontrakter.Kontrakt
import no.nav.familie.ks.kontrakter.søknad.Søknad
import no.nav.familie.ks.kontrakter.søknad.toSøknad
import java.io.File
import java.io.IOError
import java.io.IOException

class SøknadTestdata {
    companion object {
        val mapper: ObjectMapper = ObjectMapper()

        const val morAktørId = "1300000000001"
        const val morPersonident = "00000000001"

        const val farAktørId = "1300000000002"
        const val farPersonident = "00000000002"

        const val barnAktørId = "1300000000003"
        const val barnPersonident = "00000000003"

        const val utenlandskBarnAktørId = "1300000000004"
        const val utenlandskBarnPersonident = "00000000004"

        const val utenlandskMorAktørId = "1300000000005"
        const val utenlandskMorPersonident = "00000000005"

        const val utenlandskFarAktørId = "1300000000006"
        const val utenlandskFarPersonident = "00000000006"

        @JvmStatic
        fun norskFamilieUtenAnnenPartOgUtenBarnehageplass(): Søknad {
            return getFile("SøknadUtenBarnehageplassUtenAnnenPart.json").toSøknad()
        }

        @JvmStatic
        fun norskFamilieUtenBarnehageplass(): Søknad {
            return getFile("SøknadNorskFamilieUtenBarnehageplass.json").toSøknad()
        }

        @JvmStatic
        fun norskFamilieGradertBarnehageplass(): Søknad {
            return getFile("SøknadNorskFamilieGradertBarnehageplass.json").toSøknad()
        }

        @JvmStatic
        fun norskFamilieMedBarnehageplass(): Søknad {
            return getFile("SøknadNorskFamilieMedBarnehageplass.json").toSøknad()
        }

        @JvmStatic
        fun enForelderIUtlandUtenBarnehageplass(): Søknad {
            return getFile("SøknadEnForelderIUtlandUtenBarnehageplass.json").toSøknad()
        }

        @JvmStatic
        fun utenlandskFamilieUtenBarnehageplass(): Søknad {
            return getFile("SøknadUtenlandskFamilieUtenBarnehageplass.json").toSøknad()
        }

        @JvmStatic
        fun utenlandskFamilieMedBarnehageplass(): Søknad {
            return getFile("SøknadUtenlandskFamilieMedBarnehageplass.json").toSøknad()
        }

        @JvmStatic
        fun tilknytningUtlandUtenBarnehageplass(): Søknad {
            return getFile("soknadTilknytningUtlandUtenBarnehageplass.json").toSøknad()
        }

        fun getFile(filnavn: String): String {
            return File(String.format("src/main/resources/søknader/%s", filnavn)).readText()
        }
    }

}