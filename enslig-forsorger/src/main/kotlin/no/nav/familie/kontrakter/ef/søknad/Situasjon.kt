@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Situasjon(val gjelderDetteDeg: Felt<List<String>>,
                     val sykdom: Felt<Dokument>? = null,
                     val barnsSykdom: Felt<Dokument>? = null,
                     val manglendeBarnepass: Felt<Dokument>? = null,
                     val barnMedSærligeBehov: Felt<Dokument>? = null,
                     val arbeidskontrakt: Felt<Dokument>? = null,
                     val oppstartNyJobb: Felt<LocalDate>? = null,
                     val utdanningstilbud: Felt<Dokument>? = null,
                     val oppstartUtdanning: Felt<LocalDate>? = null,
                     val sagtOppEllerRedusertStilling: Felt<String>? = null,
                     val oppsigelseReduksjonÅrsak: Felt<String>? = null,
                     val oppsigelseReduksjonTidspunkt: Felt<LocalDate>? = null,
                     val oppsigelseReduksjonDokumentasjon: Felt<Dokument>? = null)