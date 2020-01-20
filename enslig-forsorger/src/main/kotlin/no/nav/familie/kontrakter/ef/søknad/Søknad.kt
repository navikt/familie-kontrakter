package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Søknad(val personalia: Felt<Personalia>,
                  val sivilstandsdetaljer: Felt<Sivilstandsdetaljer>,
                  val medlemskapsdetaljer: Felt<Medlemskapsdetaljer>,
                  val bosituasjon: Felt<Bosituasjon>,
                  val sivilstandsplaner: Felt<Sivilstandsplaner>? = null,
                  val folkeregisterbarn: Felt<List<Folkeregisterbarn>>? = null,
                  val kommendeBarn: Felt<List<KommendeBarn>>? = null,
                  val aktivitet: Felt<Aktivitet>,
                  val situasjon: Felt<Situasjon>,
                  val stønadsstart: Felt<Stønadsstart>)
