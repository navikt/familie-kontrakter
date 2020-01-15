package no.nav.familie.kontrakter.ef.søknad

data class Søknad(val personalia: Personalia,
                  val sivilstandsdetaljer: Sivilstandsdetaljer,
                  val medlemskapsdetaljer: Medlemskapsdetaljer,
                  val bosituasjon: Bosituasjon,
                  val sivilstandsplaner: Sivilstandsplaner?,
                  val folkeregisterbarn: List<Folkeregisterbarn>?,
                  val kommendeBarn: List<KommendeBarn>?,
                  val aktivitet: Aktivitet,
                  val situasjon: Situasjon,
                  val stønadsstart: Stønadsstart)
