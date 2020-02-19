package no.nav.familie.kontrakter.ef.søknad

data class Søknad(val personalia: Søknadsfelt<Personalia>,
                  val sivilstandsdetaljer: Søknadsfelt<Sivilstandsdetaljer>,
                  val medlemskapsdetaljer: Søknadsfelt<Medlemskapsdetaljer>,
                  val bosituasjon: Søknadsfelt<Bosituasjon>,
                  val sivilstandsplaner: Søknadsfelt<Sivilstandsplaner>? = null,
                  val folkeregisterbarn: Søknadsfelt<List<RegistrertBarn>>? = null,
                  val kommendeBarn: Søknadsfelt<List<NyttBarn>>? = null,
                  val aktivitet: Søknadsfelt<Aktivitet>,
                  val situasjon: Søknadsfelt<Situasjon>,
                  val stønadsstart: Søknadsfelt<Stønadsstart>)
