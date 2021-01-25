package no.nav.familie.kontrakter.felles.tilbakekreving

import no.nav.familie.kontrakter.felles.PersonIdent
import java.time.LocalDate

data class Verge(val vergeType: VergeType,
                 val gyldigFom: LocalDate,
                 val gyldigTom: LocalDate,
                 val navn: String,
                 val organisasjonsnummer: String? = null,
                 val personIdent: PersonIdent? = null)

enum class VergeType(val navn: String) {
    BARN("Verge for barn under 18 år"),
    FBARN("Verge for foreldreløst barn under 18 år"),
    VOKSEN("Verge for voksen"),
    ADVOKAT("Advokat/advokatfullmektig"),
    ANNEN_F("Annen fullmektig"),
    UDEFINERT("UDefinert")
}

