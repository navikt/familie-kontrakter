package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

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