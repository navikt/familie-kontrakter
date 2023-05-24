package no.nav.familie.kontrakter.ef.søknad

data class Aktivitet(
    val hvordanErArbeidssituasjonen: Søknadsfelt<List<String>>,
    val arbeidsforhold: Søknadsfelt<List<Arbeidsgiver>>? = null,
    @Deprecated("Bruk firmaer istedenfor") val selvstendig: Søknadsfelt<Selvstendig>? = null,
    val firmaer: Søknadsfelt<List<Selvstendig>>? = null,
    val virksomhet: Søknadsfelt<Virksomhet>? = null,
    val arbeidssøker: Søknadsfelt<Arbeidssøker>? = null,
    val underUtdanning: Søknadsfelt<UnderUtdanning>? = null,
    val aksjeselskap: Søknadsfelt<List<Aksjeselskap>>? = null,
    val erIArbeid: Søknadsfelt<String>? = null,
    val erIArbeidDokumentasjon: Søknadsfelt<Dokumentasjon>? = null,
)

/**
 * erIArbeid, erIArbeidDokumentasjon: gjelder Barnetilsyn
 */
