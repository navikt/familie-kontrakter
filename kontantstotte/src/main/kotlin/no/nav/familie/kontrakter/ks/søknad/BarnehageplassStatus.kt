package no.nav.familie.kontrakter.ks.søknad

enum class BarnehageplassStatus(
    val beskrivelse: String,
) {
    @Suppress("ktlint:standard:enum-entry-name-case")
    garIkkeIBarnehage("Går ikke i barnehage"),

    @Suppress("ktlint:standard:enum-entry-name-case")
    harBarnehageplass("Har barnehageplass"),

    @Suppress("ktlint:standard:enum-entry-name-case")
    harSluttetIBarnehage("Har sluttet i barnehage"),

    @Suppress("ktlint:standard:enum-entry-name-case")
    skalBegynneIBarnehage("Skal begynne i barnehage"),

    @Suppress("ktlint:standard:enum-entry-name-case")
    skalSlutteIBarnehage("Skal slutte i barnehage"),
}
