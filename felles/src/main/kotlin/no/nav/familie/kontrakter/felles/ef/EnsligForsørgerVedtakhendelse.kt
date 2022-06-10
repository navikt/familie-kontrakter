package no.nav.familie.kontrakter.felles.ef

data class EnsligForsørgerVedtakhendelse(
    val behandlingId: Long,
    val personIdent: String,
    val stønadType: StønadType
)
