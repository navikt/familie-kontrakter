package no.nav.familie.kontrakter.felles.oppgave.v2

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import java.time.OffsetDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class OppgaveV2(
    val id: Long,
    val kategorisering: Kategorisering,
    val fordeling: Fordeling,
    val prioritet: Prioritet,
    val nokkelord: List<String>,
    val versjon: Int,
    val status: Status,
    val opprettet: Historikk,
    val beskrivelse: String? = null,
    val aktivDato: LocalDate? = null,
    val fristDato: LocalDate? = null,
    val bruker: Bruker? = null,
    val arkivreferanse: Arkivreferanse? = null,
    val tilknyttetSystem: String? = null,
    val endret: Historikk? = null,
    val lukket: Historikk? = null,
    val utvidelser: Map<String, Any?>? = null,
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class Fordeling(
        val enhet: Enhet,
        val mappe: Mappe? = null,
        val medarbeider: Medarbeider? = null,
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class Historikk(
        val tidspunkt: OffsetDateTime,
        val av: UtfortAv? = null,
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class UtfortAv(
        val enhet: Enhet? = null,
        val medarbeider: Medarbeider? = null,
        val system: String? = null,
    )

    enum class Status {
        AAPEN,
        FERDIGSTILT,
        FEILREGISTRERT,
    }
}
