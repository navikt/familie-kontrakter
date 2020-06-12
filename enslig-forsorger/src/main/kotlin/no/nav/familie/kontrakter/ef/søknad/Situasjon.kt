package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Situasjon(val gjelderDetteDeg: Søknadsfelt<List<String>>,
                     val sykdom: Søknadsfelt<List<Dokument>>? = null,
                     val barnsSykdom: Søknadsfelt<List<Dokument>>? = null,
                     val manglendeBarnepass: Søknadsfelt<List<Dokument>>? = null,
                     val barnMedSærligeBehov: Søknadsfelt<List<Dokument>>? = null,
                     val arbeidskontrakt: Søknadsfelt<List<Dokument>>? = null,
                     val oppstartNyJobb: Søknadsfelt<LocalDate>? = null,
                     val utdanningstilbud: Søknadsfelt<List<Dokument>>? = null,
                     val oppstartUtdanning: Søknadsfelt<LocalDate>? = null,
                     val sagtOppEllerRedusertStilling: Søknadsfelt<String>? = null,
                     val oppsigelseReduksjonÅrsak: Søknadsfelt<String>? = null,
                     val oppsigelseReduksjonTidspunkt: Søknadsfelt<LocalDate>? = null,
                     val oppsigelseReduksjonDokumentasjon: Søknadsfelt<List<Dokument>>? = null)
