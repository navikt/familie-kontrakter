@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Sivilstandsdetaljer(val giftIUtlandet: Felt<Boolean>? = null,
                               val giftIUtlandetDokumentasjon: Felt<Dokument>? = null,
                               val separertEllerSkiltIUtlandet: Felt<Boolean>? = null,
                               val separertEllerSkiltIUtlandetDokumentasjon: Felt<Dokument>? = null,
                               val søktOmSkilsmisseSeparasjon: Felt<Boolean>? = null,
                               val søknadsdato: Felt<LocalDate>? = null,
                               val separasjonsbekreftelse: Felt<Dokument>? = null,
                               val årsakEnslig: Felt<String>,
                               val samlivsbruddsdokumentasjon: Felt<Dokument>? = null,
                               val samlivsbruddsdato: Felt<LocalDate>? = null,
                               val fraflytningsdato: Felt<LocalDate>? = null,
                               val spesifikasjonAnnet: Felt<String>? = null,
                               val endringSamværsordningDato: Felt<LocalDate>? = null)