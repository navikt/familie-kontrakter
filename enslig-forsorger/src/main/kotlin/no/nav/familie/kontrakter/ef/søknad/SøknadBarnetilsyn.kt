package no.nav.familie.kontrakter.ef.søknad

data class SøknadBarnetilsyn(
    val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>,
    val personalia: Søknadsfelt<Personalia>,
    val adresseopplysninger: Søknadsfelt<Adresseopplysninger>? = null,
    val sivilstandsdetaljer: Søknadsfelt<Sivilstandsdetaljer>,
    val medlemskapsdetaljer: Søknadsfelt<Medlemskapsdetaljer>,
    val bosituasjon: Søknadsfelt<Bosituasjon>,
    val sivilstandsplaner: Søknadsfelt<Sivilstandsplaner>? = null,
    val barn: Søknadsfelt<List<Barn>>,
    val aktivitet: Søknadsfelt<Aktivitet>,
    val stønadsstart: Søknadsfelt<Stønadsstart>,
    val dokumentasjon: BarnetilsynDokumentasjon
)

data class BarnetilsynDokumentasjon(
    val barnepassordningFaktura: Søknadsfelt<Dokumentasjon>? = null,
    val avtaleBarnepasser: Søknadsfelt<Dokumentasjon>? = null,
    val arbeidstid: Søknadsfelt<Dokumentasjon>? = null,
    val roterendeArbeidstid: Søknadsfelt<Dokumentasjon>? = null,
    val spesielleBehov: Søknadsfelt<Dokumentasjon>? = null
)
