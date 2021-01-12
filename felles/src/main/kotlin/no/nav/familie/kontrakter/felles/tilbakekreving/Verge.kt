package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

data class Verge(val vergeType: VergeType,
                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                 val gyldigFom: LocalDateTime,
                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                 val gyldigTom: LocalDateTime,
                 val navn: String,
                 val organisasjonNummer: String? = null,
                 val personIdent: PersonIdent? = null) //kan aktoerId brukes istedenfor?

enum class VergeType(val kode: String, val visningsNavn: String) {
    BARN("BARN", "Verge for barn under 18 år"),
    FBARN("FBARN", "Verge for foreldreløst barn under 18 år"),
    VOKSEN("VOKSEN", "Verge for voksen"),
    ADVOKAT("ADVOKAT", "Advokat/advokatfullmektig"),
    ANNEN_F("ANNEN_F", "Annen fullmektig"),
}

