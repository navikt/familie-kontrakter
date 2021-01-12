package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent
import java.time.LocalDateTime

data class Verge(val vergeType: VergeType,
                 val gyldigFom: LocalDateTime,
                 val gyldigTom: LocalDateTime,
                 val navn: String,
                 val organisasjonsnummer: String? = null,
                 val personIdent: PersonIdent? = null) //kan aktoerId brukes istedenfor?

enum class VergeType(val kode: String, val visningsNavn: String) {
    BARN("BARN", "Verge for barn under 18 år"),
    FORELDRELØST_BARN("FORELDRELØST_BARN", "Verge for foreldreløst barn under 18 år"),
    VOKSEN("VOKSEN", "Verge for voksen"),
    ADVOKAT("ADVOKAT", "Advokat/advokatfullmektig"),
    ANNEN_FULLMEKTIG("ANNEN_FULLMEKTIG", "Annen fullmektig"),
}

