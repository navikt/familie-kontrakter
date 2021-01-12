package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Bosituasjon(val delerDuBolig: Søknadsfelt<String>,
                       val samboerdetaljer: Søknadsfelt<PersonMinimum>? = null,
                       val sammenflyttingsdato: Søknadsfelt<LocalDate>? = null,
                       val datoFlyttetFraHverandre: Søknadsfelt<LocalDate>? = null,
                       val tidligereSamboerFortsattRegistrertPåAdresse: Søknadsfelt<Dokumentasjon>? = null,
                       val skalGifteSegEllerBliSamboer: Søknadsfelt<Boolean>? = null)
