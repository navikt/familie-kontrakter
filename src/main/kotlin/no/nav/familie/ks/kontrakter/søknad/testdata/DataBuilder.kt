package no.nav.familie.ks.kontrakter.søknad.testdata

import com.fasterxml.jackson.databind.ObjectMapper
import no.nav.familie.ks.kontrakter.søknad.Søknad
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

        const val utenlandskMorAktørId = "1300000000005"
        const val utenlandskMorPersonident = "00000000005"

        const val utenlandskFarAktørId = "1300000000004"
        const val utenlandskFarPersonident = "00000000004"

        @JvmStatic
        fun norskFamilieUtenAnnenPartOgUtenBarnehageplass(): Søknad {
            try {
                return mapper.readValue(File(getFile("SoknadUtenBarnehageplassUtenAnnenPart.json")), Søknad::class.java)
            } catch (e: IOException) {
                throw IOError(e)
            }

        }

        @JvmStatic
        fun norskFamilieUtenBarnehageplass(): Søknad {
            try {
                return mapper.readValue(File(getFile("SoknadNorskFamilieUtenBarnehageplass.json")), Søknad::class.java)
            } catch (e: IOException) {
                throw IOError(e)
            }
        }

        @JvmStatic
        fun norskFamilieGradertBarnehageplass(): Søknad {
            try {
                return mapper.readValue(File(getFile("SoknadNorskFamilieGradertBarnehageplass.json")), Søknad::class.java)
            } catch (e: IOException) {
                throw IOError(e)
            }
        }

        @JvmStatic
        fun norskFamilieMedBarnehageplass(): Søknad {
            try {
                return mapper.readValue(File(getFile("SoknadNorskFamilieMedBarnehageplass.json")), Søknad::class.java)
            } catch (e: IOException) {
                throw IOError(e)
            }
        }

        @JvmStatic
        fun tilknytningUtlandUtenBarnehageplass(): Søknad {
            try {
                return mapper.readValue(File(getFile("soknadTilknytningUtlandUtenBarnehageplass.json")), Søknad::class.java)
            } catch (e: IOException) {
                throw IOError(e)
            }
        }

        fun getFile(filnavn: String): String {
            return this::class.java.getResource(String.format("json/%s", filnavn)).file
        }
    }

}