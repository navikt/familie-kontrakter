@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Sivilstandsdetaljer(val giftIUtlandet: Felt<Boolean>?,
                               val giftIUtlandetDokumentasjon: Felt<Dokument>?,
                               val separertEllerSkiltIUtlandet: Felt<Boolean>?,
                               val separertEllerSkiltIUtlandetDokumentasjon: Felt<Dokument>?,
                               val søktOmSkilsmisseSeparasjon: Felt<Boolean>?,
                               val søknadsdato: Felt<LocalDate>?,
                               val separasjonsbekreftelse: Felt<Dokument>?,
                               val årsakEnslig: Felt<String>,
                               val samlivsbruddsdokumentasjon: Felt<Dokument>?,
                               val samlivsbruddsdato: Felt<LocalDate>?,
                               val fraflytningsdato: Felt<LocalDate>?,
                               val spesifikasjonAnnet: Felt<String>?)