package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Pattern

data class Verge(val vergeType: VergeType,
                 val gyldigFom: LocalDate,
                 val gyldigTom: LocalDate,
                 val navn: String,
                 @field:Pattern(regexp= "(^$|.{9})", message = "Organisasjonsnummer er ikke riktig")
                 val organisasjonsnummer: String? = null,
                 @field:Valid
                 val personIdent: PersonIdent? = null)

enum class VergeType(val navn: String) {
    BARN("Verge for barn under 18 år"),
    FORELDRELØST_BARN("Verge for foreldreløst barn under 18 år"),
    VOKSEN("Verge for voksen"),
    ADVOKAT("Advokat/advokatfullmektig"),
    ANNEN_FULLMEKTIG("Annen fullmektig"),
    UDEFINERT("UDefinert")
}

