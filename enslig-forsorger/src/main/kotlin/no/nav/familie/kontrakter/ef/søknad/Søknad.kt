package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Søknad(val personalia: Personalia,
                  val sivilstandsdetaljer: Sivilstandsdetaljer,
                  val medlemskapsdetaljer: Medlemskapsdetaljer,
                  val bosituasjon: Bosituasjon,
                  val sivilstandsplaner: Sivilstandsplaner? = null,
                  val folkeregisterbarn: List<Folkeregisterbarn>? = null,
                  val kommendeBarn: List<KommendeBarn>? = null,
                  val aktivitet: Aktivitet,
                  val situasjon: Situasjon,
                  val stønadsstart: Stønadsstart)
