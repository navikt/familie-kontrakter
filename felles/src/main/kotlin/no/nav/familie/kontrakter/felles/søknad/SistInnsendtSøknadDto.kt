package no.nav.familie.kontrakter.felles.søknad

import no.nav.familie.kontrakter.felles.ef.StønadType
import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class SistInnsendtSøknadDto(
    val søknadsdato: LocalDate,
    val stønadType: StønadType,
)

fun SistInnsendtSøknadDto.nyereEnn(dager: Long = 30): Boolean {
    val dagensDato = LocalDate.now()
    val dagerSidenInnsending = ChronoUnit.DAYS.between(søknadsdato, dagensDato)
    return dagerSidenInnsending <= dager
}
