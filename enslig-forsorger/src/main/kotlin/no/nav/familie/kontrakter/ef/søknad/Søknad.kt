package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Søknad(val personalia: Søknadsfelt<Personalia>,
                  val sivilstandsdetaljer: Søknadsfelt<Sivilstandsdetaljer>,
                  val medlemskapsdetaljer: Søknadsfelt<Medlemskapsdetaljer>,
                  val bosituasjon: Søknadsfelt<Bosituasjon>,
                  val sivilstandsplaner: Søknadsfelt<Sivilstandsplaner>? = null,
                  val folkeregisterbarn: Søknadsfelt<List<Folkeregisterbarn>>? = null,
                  val kommendeBarn: Søknadsfelt<List<KommendeBarn>>? = null,
                  val aktivitet: Søknadsfelt<Aktivitet>,
                  val situasjon: Søknadsfelt<Situasjon>,
                  val stønadsstart: Søknadsfelt<Stønadsstart>)
