@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Situasjon(val gjelderDetteDeg: Spørsmål<List<String>>,
                     val sykdom: Dokument? = null,
                     val barnsSykdom: Dokument? = null,
                     val manglendeBarnepass: Dokument? = null,
                     val barnMedSærligeBehov: Dokument? = null,
                     val arbeidskontrakt: Dokument? = null,
                     val oppstartNyJobb: Spørsmål<LocalDate>? = null,
                     val utdanningstilbud: Dokument? = null,
                     val oppstartUtdanning: Spørsmål<LocalDate>? = null,
                     val sagtOppEllerRedusertStilling: Spørsmål<String>? = null,
                     val oppsigelseReduksjonÅrsak: Spørsmål<String>? = null,
                     val oppsigelseReduksjonTidspunkt: Spørsmål<LocalDate>? = null,
                     val oppsigelseReduksjonDokumentasjon: Dokument? = null)