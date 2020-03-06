package no.nav.familie.kontrakter.felles.personopplysning

import no.nav.familie.kontrakter.felles.personopplysning.adresse.AdressePeriode
import no.nav.familie.kontrakter.felles.personopplysning.status.PersonstatusPeriode
import no.nav.familie.kontrakter.felles.personopplysning.tilhørighet.StatsborgerskapPeriode
import java.util.*

data class PersonhistorikkInfo(val personIdent: PersonIdent,
                               val personstatushistorikk: List<PersonstatusPeriode> = ArrayList(),
                               val statsborgerskaphistorikk: List<StatsborgerskapPeriode> = ArrayList(),
                               val adressehistorikk: List<AdressePeriode> = ArrayList())
