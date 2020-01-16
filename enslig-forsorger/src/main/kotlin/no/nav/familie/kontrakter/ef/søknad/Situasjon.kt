@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Situasjon(val gjelderDetteDeg: Spørsmål<List<String>>,
                     val sykdom: Dokument?,
                     val barnsSykdom: Dokument?,
                     val manglendeBarnepass: Dokument?,
                     val barnMedSærligeBehov: Dokument?,
                     val arbeidskontrakt: Dokument?,
                     val oppstartNyJobb: Spørsmål<LocalDate>?,
                     val utdanningstilbud: Dokument?,
                     val oppstartUtdanning: Spørsmål<LocalDate>?,
                     val sagtOppEllerRedusertStilling: Spørsmål<String>?,
                     val oppsigelseReduksjonÅrsak: Spørsmål<String>?,
                     val oppsigelseReduksjonTidspunkt: Spørsmål<LocalDate>?,
                     val oppsigelseReduksjonDokumentasjon: Dokument?)