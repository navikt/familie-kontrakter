package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Bosituasjon(val delerDuBolig: Spørsmål<String>,
                       val samboerdetaljer: PersonMinimumDto,
                       val sammenflyttingsdato: Spørsmål<LocalDate>)