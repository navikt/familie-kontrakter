package no.nav.familie.kontrakter.ef.søknad

data class SøknadSkolepenger(
    val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>,
    val personalia: Søknadsfelt<Personalia>,
    val adresseopplysninger: Søknadsfelt<Adresseopplysninger>? = null,
    val sivilstandsdetaljer: Søknadsfelt<Sivilstandsdetaljer>,
    val medlemskapsdetaljer: Søknadsfelt<Medlemskapsdetaljer>,
    val bosituasjon: Søknadsfelt<Bosituasjon>,
    val sivilstandsplaner: Søknadsfelt<Sivilstandsplaner>? = null,
    val barn: Søknadsfelt<List<Barn>>,
    val utdanning: Søknadsfelt<UnderUtdanning>,
    val dokumentasjon: SkolepengerDokumentasjon,
)

data class SkolepengerDokumentasjon(val utdanningsutgifter: Søknadsfelt<Dokumentasjon>? = null)
