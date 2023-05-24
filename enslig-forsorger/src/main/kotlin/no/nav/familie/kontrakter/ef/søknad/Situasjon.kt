package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Situasjon(
    val gjelderDetteDeg: Søknadsfelt<List<String>>,
    val sykdom: Søknadsfelt<Dokumentasjon>? = null,
    val barnsSykdom: Søknadsfelt<Dokumentasjon>? = null,
    val manglendeBarnepass: Søknadsfelt<Dokumentasjon>? = null,
    val barnMedSærligeBehov: Søknadsfelt<Dokumentasjon>? = null,
    val arbeidskontrakt: Søknadsfelt<Dokumentasjon>? = null,
    val lærlingkontrakt: Søknadsfelt<Dokumentasjon>? = null,
    val oppstartNyJobb: Søknadsfelt<LocalDate>? = null,
    val utdanningstilbud: Søknadsfelt<Dokumentasjon>? = null,
    val oppstartUtdanning: Søknadsfelt<LocalDate>? = null,
    val sagtOppEllerRedusertStilling: Søknadsfelt<String>? = null,
    val oppsigelseReduksjonÅrsak: Søknadsfelt<String>? = null,
    val oppsigelseReduksjonTidspunkt: Søknadsfelt<LocalDate>? = null,
    val reduksjonAvArbeidsforholdDokumentasjon: Søknadsfelt<Dokumentasjon>? = null,
    val oppsigelseDokumentasjon: Søknadsfelt<Dokumentasjon>? = null,
)
