package no.nav.familie.ks.søknadkontrakt

import javax.validation.constraints.Pattern

data class AktørArbeidYtelseUtland(
        @Pattern(regexp = "[0-9]{13}")
        val aktørId: String,
        val arbeidIUtlandet: Standpunkt,
        val arbeidIUtlandetForklaring: String,
        val ytelseIUtlandet: Standpunkt,
        val ytelseIUtlandetForklaring: String,
        val kontantstøtteIUtlandet: Standpunkt,
        val kontantstøtteIUtlandetForklaring: String
)
