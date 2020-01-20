@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Situasjon(val gjelderDetteDeg: Felt<List<String>>,
                     val sykdom: Felt<Dokument>?,
                     val barnsSykdom: Felt<Dokument>?,
                     val manglendeBarnepass: Felt<Dokument>?,
                     val barnMedSærligeBehov: Felt<Dokument>?,
                     val arbeidskontrakt: Felt<Dokument>?,
                     val oppstartNyJobb: Felt<LocalDate>?,
                     val utdanningstilbud: Felt<Dokument>?,
                     val oppstartUtdanning: Felt<LocalDate>?,
                     val sagtOppEllerRedusertStilling: Felt<String>?,
                     val oppsigelseReduksjonÅrsak: Felt<String>?,
                     val oppsigelseReduksjonTidspunkt: Felt<LocalDate>?,
                     val oppsigelseReduksjonDokumentasjon: Felt<Dokument>?)