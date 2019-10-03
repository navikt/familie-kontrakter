package no.nav.familie.ks.kontrakter.søknad.testdata

import com.fasterxml.jackson.databind.ObjectMapper
import no.nav.familie.ks.kontrakter.søknad.Søknad
import java.io.File
import java.io.IOError
import java.io.IOException

object DataBuilder {
    val mapper: ObjectMapper = ObjectMapper()

    fun norskFamilieUtenAnnenPartOgUtenBarnehageplass(): Søknad {
        try {
            return mapper.readValue(File(getFile("SoknadUtenBarnehageplassUtenAnnenPart.json")), Søknad::class.java)
        } catch (e: IOException) {
            throw IOError(e)
        }

    }

    fun norskFamilieUtenBarnehageplass(): Søknad {
        try {
            return mapper.readValue(File(getFile("SoknadNorskFamilieUtenBarnehageplass.json")), Søknad::class.java)
        } catch (e: IOException) {
            throw IOError(e)
        }

    }

    fun norskFamilieGradertBarnehageplass(): Søknad {
        try {
            return mapper.readValue(File(getFile("SoknadNorskFamilieGradertBarnehageplass.json")), Søknad::class.java)
        } catch (e: IOException) {
            throw IOError(e)
        }

    }

    fun norskFamilieMedBarnehageplass(): Søknad {
        try {
            return mapper.readValue(File(getFile("SoknadNorskFamilieMedBarnehageplass.json")), Søknad::class.java)
        } catch (e: IOException) {
            throw IOError(e)
        }

    }

    private fun tilknytningUtlandUtenBarnehageplass(): Søknad {
        try {
            return mapper.readValue(File(getFile("soknadTilknytningUtlandUtenBarnehageplass.json")), Søknad::class.java)
        } catch (e: IOException) {
            throw IOError(e)
        }

    }

    private fun getFile(filnavn: String): String {
        return this::class.java.getResource(String.format("json/%s", filnavn)).file
    }
}