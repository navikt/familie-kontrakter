package no.nav.familie.kontrakter.felles.tilbakekreving

import java.math.BigDecimal

data class FeilutbetaltePerioder(val sumFeilutbetaling: BigDecimal,
                                 val perioder: List<Periode>)
