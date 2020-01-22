@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Situasjon(val gjelderDetteDeg: Søknadsfelt<List<String>>,
                     val sykdom: Søknadsfelt<Dokument>? = null,
                     val barnsSykdom: Søknadsfelt<Dokument>? = null,
                     val manglendeBarnepass: Søknadsfelt<Dokument>? = null,
                     val barnMedSærligeBehov: Søknadsfelt<Dokument>? = null,
                     val arbeidskontrakt: Søknadsfelt<Dokument>? = null,
                     val oppstartNyJobb: Søknadsfelt<LocalDate>? = null,
                     val utdanningstilbud: Søknadsfelt<Dokument>? = null,
                     val oppstartUtdanning: Søknadsfelt<LocalDate>? = null,
                     val sagtOppEllerRedusertStilling: Søknadsfelt<String>? = null,
                     val oppsigelseReduksjonÅrsak: Søknadsfelt<String>? = null,
                     val oppsigelseReduksjonTidspunkt: Søknadsfelt<LocalDate>? = null,
                     val oppsigelseReduksjonDokumentasjon: Søknadsfelt<Dokument>? = null)
