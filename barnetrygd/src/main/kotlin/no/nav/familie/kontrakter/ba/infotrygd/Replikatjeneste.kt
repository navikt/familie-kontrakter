package no.nav.familie.kontrakter.ba.infotrygd

import java.time.LocalDate


data class InfotrygdSøkRequest(val brukere: List<String>,
                               val barn: List<String>? = null)

data class InfotrygdSøkResponse<T>(
        val bruker: List<T>,
        val barn: List<T>,
)

data class Barn(
        val barnFnr: String? = null,
        val barnetrygdTom: String? = null,
        val stønadstype: String? = null,
)

data class Stønad(
        val id: Long? = null,
        val status: String? = null,
        val tekstkode: String? = null,
        val iverksattFom: String? = null,
        val virkningFom: String? = null,
        val barn: List<Barn> = emptyList(),
        val opphørtIver: String? = null,
        val opphørtFom: String? = null,
        val opphørsgrunn: String? = null,
        val delytelse: List<Delytelse> = emptyList(),
        val antallBarn: Int? = null,
)

data class Sak(
        val id: Long? = null,
        val saksnr: String? = null,
        val saksblokk: String? = null,
        val regDato: LocalDate? = null,
        val mottattdato: LocalDate? = null,
        val kapittelnr: String? = null,
        val valg: String? = null,
        val undervalg: String? = null,
        val type: String? = null,
        val nivå: String? = null,
        val resultat: String? = null,
        val vedtaksdato: LocalDate? = null,
        val iverksattdato: LocalDate? = null,
        val stønad: Stønad? = null,
        val årsakskode: String? = null,
        val behenEnhet: String? = null,
        val regAvEnhet: String? = null,
        val status: String,
        val tkNr: String? = null,
        val region: String? = null,
)

data class Delytelse(
        val fom: LocalDate,
        val tom: LocalDate? = null,
        val beløp: Double,
        val typeDelytelse: String,
        val oppgjørsordning: String? = null,
        val typeUtbetaling: String,
)
