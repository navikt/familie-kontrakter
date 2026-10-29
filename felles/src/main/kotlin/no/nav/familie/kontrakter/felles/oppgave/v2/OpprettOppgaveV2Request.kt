package no.nav.familie.kontrakter.felles.oppgave.v2

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class OpprettOppgaveV2Request(
    val kategorisering: Kategorisering,
    val fordeling: Fordeling? = null,
    val beskrivelse: String? = null,
    val prioritet: Prioritet? = null,
    val fristDato: LocalDate? = null,
    val aktivDato: LocalDate? = null,
    val nokkelord: Set<String>? = null,
    val bruker: Bruker? = null,
    val arkivreferanse: Arkivreferanse? = null,
    val tilknyttetSystem: String? = null,
    val meta: Meta? = null,
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class Fordeling(
        val enhet: Enhet? = null,
        val mappe: Mappe? = null,
        val medarbeider: Medarbeider? = null,
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class Meta(
        val representerer: Representerer,
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class Representerer(
        val enhet: Enhet,
    )
}
