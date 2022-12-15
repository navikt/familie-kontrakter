package no.nav.familie.kontrakter.felles.klage

import java.time.LocalDateTime

data class FagsystemVedtak(
    val eksternBehandlingId: String,
    val behandlingstype: String,
    val resultat: String,
    val vedtakstidspunkt: LocalDateTime,
    val fagsystemType: FagsystemType,
    val vedtakType: VedtakType
)

@Deprecated("Bruk VedtakType")
enum class FagsystemType {
    ORDNIÆR, // brukes for behandlinger fra ef-sak/ba-sak
    TILBAKEKREVING
}

enum class VedtakType {
    ORDINÆR, // brukes for behandlinger fra ef-sak/ba-sak
    TILBAKEKREVING,
    SANKSJON_1_MND
}
