@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Sivilstandsdetaljer(val giftIUtlandet: Søknadsfelt<Boolean>? = null,
                               val giftIUtlandetDokumentasjon: Søknadsfelt<Dokument>? = null,
                               val separertEllerSkiltIUtlandet: Søknadsfelt<Boolean>? = null,
                               val separertEllerSkiltIUtlandetDokumentasjon: Søknadsfelt<Dokument>? = null,
                               val søktOmSkilsmisseSeparasjon: Søknadsfelt<Boolean>? = null,
                               val søknadsdato: Søknadsfelt<LocalDate>? = null,
                               val separasjonsbekreftelse: Søknadsfelt<Dokument>? = null,
                               val årsakEnslig: Søknadsfelt<String>,
                               val samlivsbruddsdokumentasjon: Søknadsfelt<Dokument>? = null,
                               val samlivsbruddsdato: Søknadsfelt<LocalDate>? = null,
                               val fraflytningsdato: Søknadsfelt<LocalDate>? = null,
                               val spesifikasjonAnnet: Søknadsfelt<String>? = null,
                               val endringSamværsordningDato: Søknadsfelt<LocalDate>? = null)
