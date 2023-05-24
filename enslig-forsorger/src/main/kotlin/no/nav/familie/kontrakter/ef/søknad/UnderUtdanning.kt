package no.nav.familie.kontrakter.ef.søknad

data class UnderUtdanning(
    val skoleUtdanningssted: Søknadsfelt<String>,
    @Deprecated("Bruk gjeldende utdanning") val utdanning: Søknadsfelt<TidligereUtdanning>?,
    val gjeldendeUtdanning: Søknadsfelt<GjeldendeUtdanning>?,
    val offentligEllerPrivat: Søknadsfelt<String>,
    val heltidEllerDeltid: Søknadsfelt<String>,
    val hvorMyeSkalDuStudere: Søknadsfelt<Int>?,
    val hvaErMåletMedUtdanningen: Søknadsfelt<String>?,
    val utdanningEtterGrunnskolen: Søknadsfelt<Boolean>,
    val tidligereUtdanninger: Søknadsfelt<List<TidligereUtdanning>>? = null,
    val semesteravgift: Søknadsfelt<Double>? = null,
    val studieavgift: Søknadsfelt<Double>? = null,
    val eksamensgebyr: Søknadsfelt<Double>? = null,
)

/**
 *  semesteravgift, studieavgift, eksamensgebyr gjelder kun Skolepenger
 */
