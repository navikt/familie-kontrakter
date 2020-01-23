package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Bosituasjon(val delerDuBolig: Søknadsfelt<String>,
                       val samboerdetaljer: Søknadsfelt<PersonMinimum>? = null,
                       val sammenflyttingsdato: Søknadsfelt<LocalDate>? = null)
