package no.nav.familie.kontrakter.felles

import javax.validation.constraints.Pattern

data class PersonIdent(
    @field:Pattern(regexp = "(^$|.{11})", message = "PersonIdent er ikke riktig") val ident: String,
    @field:Pattern(regexp = "(^$|.{13})", message = "AktørId er ikke riktig") val aktørId: String? = null
)
