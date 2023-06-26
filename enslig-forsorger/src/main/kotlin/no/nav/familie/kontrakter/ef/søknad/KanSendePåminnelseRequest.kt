package no.nav.familie.kontrakter.ef.søknad

import no.nav.familie.kontrakter.felles.ef.StønadType
import java.time.LocalDateTime

data class KanSendePåminnelseRequest(
    val personIdent: String,
    val stønadType: StønadType,
    val innsendtSøknadTidspunkt: LocalDateTime,
)
