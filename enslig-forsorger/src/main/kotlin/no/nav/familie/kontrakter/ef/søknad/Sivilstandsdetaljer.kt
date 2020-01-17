@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Sivilstandsdetaljer(val giftIUtlandet: Spørsmål<Boolean>? = null,
                               val giftIUtlandetDokumentasjon: Dokument? = null,
                               val separertEllerSkiltIUtlandet: Spørsmål<Boolean>? = null,
                               val separertEllerSkiltIUtlandetDokumentasjon: Dokument? = null,
                               val søktOmSkilsmisseSeparasjon: Spørsmål<Boolean>? = null,
                               val søknadsdato: Spørsmål<LocalDate>? = null,
                               val separasjonsbekreftelse: Dokument? = null,
                               val årsakEnslig: Spørsmål<String>,
                               val samlivsbruddsdokumentasjon: Dokument? = null,
                               val samlivsbruddsdato: LocalDate? = null,
                               val fraflytningsdato: LocalDate? = null,
                               val spesifikasjonAnnet: String? = null)