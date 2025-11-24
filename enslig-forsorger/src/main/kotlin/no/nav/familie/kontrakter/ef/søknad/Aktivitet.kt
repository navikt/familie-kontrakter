package no.nav.familie.kontrakter.ef.søknad

/**
 * erIArbeid, erIArbeidDokumentasjon: gjelder Barnetilsyn
 */

data class Aktivitet(
    val erIArbeid: Søknadsfelt<String>? = null,
    val hvordanErArbeidssituasjonen: Søknadsfelt<List<String>>,
    val arbeidsforhold: Søknadsfelt<List<Arbeidsgiver>>? = null,
    @Deprecated("Bruk firmaer istedenfor") val selvstendig: Søknadsfelt<Selvstendig>? = null,
    val firmaer: Søknadsfelt<List<Selvstendig>>? = null,
    val virksomhet: Søknadsfelt<Virksomhet>? = null,
    val arbeidssøker: Søknadsfelt<Arbeidssøker>? = null,
    val underUtdanning: Søknadsfelt<UnderUtdanning>? = null,
    val aksjeselskap: Søknadsfelt<List<Aksjeselskap>>? = null,
    val erIArbeidDokumentasjon: Søknadsfelt<Dokumentasjon>? = null,
)
