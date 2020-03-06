package no.nav.familie.kontrakter.felles.personopplysning.adresse

import no.nav.familie.kontrakter.felles.personopplysning.status.PersonstatusType
import java.util.*

class Adresseinfo(val gjeldendePostadresseType: AdresseType,
                  val mottakerNavn: String,
                  val adresselinje1: String?,
                  val adresselinje2: String?,
                  val adresselinje3: String?,
                  val adresselinje4: String?,
                  val postNr: String?,
                  val poststed: String?,
                  val land: String?,
                  val personstatus: PersonstatusType?)
