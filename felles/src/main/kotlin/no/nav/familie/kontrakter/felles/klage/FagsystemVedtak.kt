package no.nav.familie.kontrakter.felles.klage

import java.time.LocalDateTime

data class FagsystemVedtak(
    val eksternBehandlingId: String,
    val behandlingstype: String,
    val resultat: String,
    val vedtakstidspunkt: LocalDateTime,
    val fagsystemType: FagsystemType,
    val nasjonalitetType: NasjonalitetType
)

enum class FagsystemType {
    ORDNIÆR, // brukes for behandlinger fra ef-sak/ba-sak
    TILBAKEKREVING,
    SANKSJON_1_MND,
    UTESTENGELSE
}

enum class NasjonalitetType(dvhKode: String){
    NASJONAL("Nasjonal"),
    UTLAND("Utland")
}
