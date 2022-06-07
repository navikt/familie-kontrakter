package no.nav.familie.kontrakter.ef.søknad

data class SøknadSkolepenger(
    val personalia: Søknadsfelt<Personalia>,
    val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>,
    val sivilstandsdetaljer: Søknadsfelt<Sivilstandsdetaljer>,
    val medlemskapsdetaljer: Søknadsfelt<Medlemskapsdetaljer>,
    val bosituasjon: Søknadsfelt<Bosituasjon>,
    val sivilstandsplaner: Søknadsfelt<Sivilstandsplaner>? = null,
    val barn: Søknadsfelt<List<Barn>>,
    val utdanning: Søknadsfelt<UnderUtdanning>,
    val dokumentasjon: SkolepengerDokumentasjon
)

data class SkolepengerDokumentasjon(val utdanningsutgifter: Søknadsfelt<Dokumentasjon>? = null)
