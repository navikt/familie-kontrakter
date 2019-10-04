package no.nav.familie.ks.kontrakter.søknad.testdata

import com.fasterxml.jackson.databind.ObjectMapper
import no.nav.familie.ks.kontrakter.søknad.Søknad
import java.io.File
import java.io.IOError
import java.io.IOException

class SøknadTestdata {
    companion object {
        val mapper: ObjectMapper = ObjectMapper()

        @JvmStatic
        val morAktørId = "1300000000001"

        @JvmStatic
        val morPersonident = "00000000001"

        @JvmStatic
        val farAktørId = "1300000000002"

        @JvmStatic
        val farPersonident = "00000000002"

        @JvmStatic
        val barnAktørId = "1300000000003"

        @JvmStatic
        val barnPersonident = "00000000003"

        @JvmStatic
        val utenlandskFarAktørId = "1300000000004"

        @JvmStatic
        val utenlandskFarPersonident = "00000000004"

        @JvmStatic
        val utenlandskMorAktørId = "1300000000005"

        @JvmStatic
        val utenlandskMorPersonident = "00000000005"



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