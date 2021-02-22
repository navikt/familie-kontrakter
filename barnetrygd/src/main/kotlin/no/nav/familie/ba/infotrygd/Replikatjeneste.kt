package no.nav.familie.ba.sak.infotrygd

import java.time.LocalDate


data class InfotrygdSøkRequest(val brukere: List<String>,
                               val barn: List<String>? = null)

data class InfotrygdSøkResponse<T>(
        val bruker: List<T>,
        val barn: List<T>,
)

data class Stønad(
        val stønadId: Long,
        val sakNr: String? = null,
        val opphørtFom: String? = null,
        val opphørsgrunn: String? = null,
)

data class Sak(
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
        val stønadList: List<Stønad> = emptyList(),
        val årsakskode: String? = null,
        val behenEnhet: String? = null,
        val regAvEnhet: String? = null,
        val status: String,
)