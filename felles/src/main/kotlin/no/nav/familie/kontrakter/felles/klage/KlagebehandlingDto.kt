package no.nav.familie.kontrakter.felles.klage

import com.fasterxml.jackson.annotation.JsonAutoDetect
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class KlagebehandlingDto(
    val id: UUID,
    val fagsakId: UUID,
    val status: BehandlingStatus,
    val opprettet: LocalDateTime,
    val mottattDato: LocalDate,
    val resultat: BehandlingResultat?,
    val årsak: Årsak?,
    val vedtaksdato: LocalDateTime?,
    val klageinstansResultat: List<KlageinstansResultatDto> = emptyList(),
    val henlagtÅrsak: HenlagtÅrsak? = null,
)

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class KlageinstansResultatDto(
    val type: BehandlingEventType,
    val utfall: KlageinstansUtfall?,
    val mottattEllerAvsluttetTidspunkt: LocalDateTime,
    val journalpostReferanser: List<String>,
    val årsakFeilregistrert: String?,
)
