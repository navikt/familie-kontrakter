package no.nav.familie.kontrakter.felles

import jakarta.validation.constraints.Pattern

data class PersonIdent(
    @field:Pattern(regexp = "(^$|.{11})", message = "PersonIdent er ikke riktig") val ident: String,
)
