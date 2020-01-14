package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Sivilstandsplaner(val harPlaner: Spørsmål<Boolean>,
                             val fraDato: Spørsmål<LocalDate>)