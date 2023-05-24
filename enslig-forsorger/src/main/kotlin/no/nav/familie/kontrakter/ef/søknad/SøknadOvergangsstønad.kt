package no.nav.familie.kontrakter.ef.søknad

data class SøknadOvergangsstønad(
    val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>,
    val personalia: Søknadsfelt<Personalia>,
    val adresseopplysninger: Søknadsfelt<Adresseopplysninger>? = null,
    val sivilstandsdetaljer: Søknadsfelt<Sivilstandsdetaljer>,
    val medlemskapsdetaljer: Søknadsfelt<Medlemskapsdetaljer>,
    val bosituasjon: Søknadsfelt<Bosituasjon>,
    val sivilstandsplaner: Søknadsfelt<Sivilstandsplaner>? = null,
    val barn: Søknadsfelt<List<Barn>>,
    val aktivitet: Søknadsfelt<Aktivitet>,
    val situasjon: Søknadsfelt<Situasjon>,
    val stønadsstart: Søknadsfelt<Stønadsstart>,
)
