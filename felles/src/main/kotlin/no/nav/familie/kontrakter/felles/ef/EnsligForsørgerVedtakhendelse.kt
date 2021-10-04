package no.nav.familie.kontrakter.felles.ef

import java.time.LocalDate

data class EnsligForsørgerVedtakhendelse(val fagsakId: Long,
                                         val behandlingId: Long,
                                         val personIdent: String,
                                         val vedtaksdato: LocalDate,
                                         val stønadType: StønadType)