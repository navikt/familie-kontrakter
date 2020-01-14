package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class PersonMinimumDto(val navn: String,
                            val fødselsnummer: Fødselsnummer,
                            val fødselsdato: LocalDate,
                            val adresse: Adresse,
                            val land: String)