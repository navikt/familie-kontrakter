package no.nav.familie.kontrakter.felles.personopplysning.status

import no.nav.familie.kontrakter.felles.personopplysning.Periode

data class PersonstatusPeriode(val periode: Periode,
                               val personstatus: PersonstatusType)

