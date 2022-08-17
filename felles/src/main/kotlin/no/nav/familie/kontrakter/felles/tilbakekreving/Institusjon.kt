package no.nav.familie.kontrakter.felles.tilbakekreving

import javax.validation.constraints.Pattern

data class Institusjon(
    @field:Pattern(regexp = "(^$|.{9})", message = "Organisasjonsnummer for institusjon er ikke riktig")
    val organisasjonsnummer: String,
    val navn: String
)
