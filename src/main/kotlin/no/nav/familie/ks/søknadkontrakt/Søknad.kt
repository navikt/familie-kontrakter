package no.nav.familie.ks.søknadkontrakt

import java.time.LocalDateTime

data class Søknad(
    val innsendtTidspunkt: LocalDateTime,
    val aktørerArbeidYtelseIUtlandet: Set<AktørArbeidYtelseUtland>,
    val oppgittErklæring: OppgittErklæring
)