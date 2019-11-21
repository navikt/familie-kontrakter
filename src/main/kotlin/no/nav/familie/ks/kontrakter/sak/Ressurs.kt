package no.nav.familie.ks.kontrakter.sak

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.exc.MismatchedInputException
import no.nav.familie.ks.kontrakter.Kontrakt
import no.nav.familie.ks.kontrakter.objectMapper
import java.io.PrintWriter
import java.io.StringWriter

data class Ressurs(
    val data: JsonNode?,
    val status: Status,
    val melding: String,
    val stacktrace: String?

) : Kontrakt {
    enum class Status { SUKSESS, FEILET, IKKE_HENTET, IKKE_TILGANG }

    companion object {

        inline fun <reified T> success(data: T): Ressurs {
            return Ressurs(
                data = objectMapper.valueToTree(data),
                status = Status.SUKSESS,
                melding = "Innhenting av data var vellykket",
                stacktrace = null
            )
        }

        fun <T> success(data: T, melding: String?): Ressurs = Ressurs(
            data = objectMapper.valueToTree(data),
            status = Status.SUKSESS,
            melding = melding ?: "Innhenting av data var vellykket",
            stacktrace = null
        )

        fun failure(errorMessage: String? = null, error: Throwable? = null): Ressurs = Ressurs(
            data = null,
            status = Status.FEILET,
            melding = errorMessage ?: "Kunne ikke hente data: ${error?.message}",
            stacktrace = error?.textValue()
        )

        fun ikkeTilgang(melding: String): Ressurs = Ressurs(
            data = null,
            status = Status.IKKE_TILGANG,
            melding = melding,
            stacktrace = null
        )

        private fun Throwable.textValue(): String {
            val sw = StringWriter()
            this.printStackTrace(PrintWriter(sw))
            return sw.toString()
        }
    }

    fun <T> convert(responseType: Class<T>): T? {
        try {
            return objectMapper.convertValue(data, responseType)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Kan ikke koverterer $data til $responseType", e.cause)
        }
    }

    fun toJson(): String = objectMapper.writeValueAsString(this)
    override fun toString(): String {
        return "Ressurs(data=$data, status=$status, melding='$melding')"
    }
}



