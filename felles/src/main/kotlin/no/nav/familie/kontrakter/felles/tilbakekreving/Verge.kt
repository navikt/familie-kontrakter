package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Pattern

data class Verge(val vergetype: Vergetype,
                 val gyldigFom: LocalDate,
                 val gyldigTom: LocalDate,
                 val navn: String,
                 @field:Pattern(regexp= "(^$|.{9})", message = "Organisasjonsnummer er ikke riktig")
                 val organisasjonsnummer: String? = null,
                 @field:Valid
                 val personIdent: PersonIdent? = null)

enum class Vergetype(val navn: String) {
    VERGE_FOR_BARN("Verge for barn under 18 år"),
    VERGE_FOR_FORELDRELØST_BARN("Verge for foreldreløst barn under 18 år"),
    VERGE_FOR_VOKSEN("Verge for voksen"),
    ADVOKAT("Advokat/advokatfullmektig"),
    ANNEN_FULLMEKTIG("Annen fullmektig"),
    UDEFINERT("UDefinert")
}

