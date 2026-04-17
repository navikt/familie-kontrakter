package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class SøknadOvergangsstønadRegelendring2026(
    val erRegelendring2026: Boolean = true,
    val innsendingsdetaljer: Søknadsfelt<Innsendingsdetaljer>,
    val personalia: Søknadsfelt<Personalia>,
    val adresseopplysninger: Søknadsfelt<Adresseopplysninger>? = null,
    val sivilstandsdetaljer: Søknadsfelt<Sivilstandsdetaljer>,
    val medlemskapsdetaljer: Søknadsfelt<Medlemskapsdetaljer>,
    val bosituasjon: Søknadsfelt<Bosituasjon>,
    val sivilstandsplaner: Søknadsfelt<Sivilstandsplaner>? = null,
    val barn: Søknadsfelt<List<Barn>>,
    val hvaSituasjon: Søknadsfelt<List<String>>,
    val harInntekt: Søknadsfelt<List<String>>,
    val firmaer: Søknadsfelt<List<Selvstendig>>? = null,
    val sagtOppEllerRedusertStilling: Søknadsfelt<String>? = null,
    val begrunnelseSagtOppEllerRedusertStilling: Søknadsfelt<String>? = null,
    val datoSagtOppEllerRedusertStilling: Søknadsfelt<LocalDate>? = null,
    val stønadsstart: Søknadsfelt<Stønadsstart>,
)
