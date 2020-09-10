package no.nav.familie.kontrakter.felles.oppgave

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import no.nav.familie.kontrakter.felles.abstraction.QueryObject
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.LocalDateTime

data class FinnOppgaveRequest(@JsonDeserialize(using = TemaDeserializer::class)
                              val tema: Tema,
                              val behandlingstema: Behandlingstema? = null,
                              val oppgavetype: Oppgavetype? = null,
                              val enhet: String? = null,
                              val saksbehandler: String? = null,
                              val journalpostId: String? = null,
                              val tilordnetRessurs: String? = null,
                              val tildeltRessurs: Boolean? = null,
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                              val opprettetFomTidspunkt: LocalDateTime? = null,
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                              val opprettetTomTidspunkt: LocalDateTime? = null,
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                              val fristFomDato: LocalDate? = null,
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                              val fristTomDato: LocalDate? = null,
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                              val aktivFomDato: LocalDate? = null,
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                              val aktivTomDato: LocalDate? = null,
                              val limit: Long? = null,
                              val offset: Long? = null) : QueryObject()

class TemaDeserializer : StdDeserializer<Tema>(Tema::class.java) {
    override fun deserialize(jp: JsonParser?, p1: DeserializationContext?): Tema {
        val node: JsonNode = jp!!.codec.readTree(jp)
        return when (val tema = node.asText()) {
            "BAR" -> Tema.BAR
            "ENF" -> Tema.ENF
            "KON" -> Tema.KON
            else -> Tema.valueOf(tema)
        }
    }
}