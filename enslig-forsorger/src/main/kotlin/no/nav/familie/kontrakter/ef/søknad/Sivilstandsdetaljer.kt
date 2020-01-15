package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Sivilstandsdetaljer(val giftIUtlandet: Spørsmål<Boolean>?,
                               val giftIUtlandetDokumentasjon: Dokument?,
                               val separertElleSkiltIUtlandet: Spørsmål<Boolean>?,
                               val separertElleSkiltIUtlandetDokumentasjon: Dokument?,
                               val søktOmSkilsmisseSeparasjon: Spørsmål<Boolean>?,
                               val søknadsdato: Spørsmål<@ContextualSerialization LocalDate>?,
                               val separasjonsbekreftelse: Dokument?,
                               val årsakEnslig: Spørsmål<String>,
                               val samlivsbruddsdokumentasjon: Dokument?,
                               val samlivsbruddsdato: @ContextualSerialization LocalDate?,
                               val fraflytningsdato: @ContextualSerialization LocalDate?,
                               val spesifikasjonAnnet: String?)