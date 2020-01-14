package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Arbeidsgiver(val arbeidsgivernavn: String,
                        val stillingsprosent: String,
                        val fastEllerMidlertidig: Spørsmål<String>,
                        val sluttdato: LocalDate)