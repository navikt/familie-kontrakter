package no.nav.familie.kontrakter.ks.søknad

enum class TilknytningTilUtlandVerdier(
    val beskrivelse: String,
) {
    @Suppress("ktlint:standard:enum-entry-name-case")
    jaINorge("Ja, i Norge"),

    @Suppress("ktlint:standard:enum-entry-name-case")
    jaIEOS("Ja, i et EØS-land"),

    @Suppress("ktlint:standard:enum-entry-name-case")
    jaLeggerSammenPerioderEOS("Ja, hvis jeg legger sammen perioder i EØS-land"),

    @Suppress("ktlint:standard:enum-entry-name-case")
    nei("Nei"),

    @Suppress("ktlint:standard:enum-entry-name-case")
    Ubesvart("Ubesvart"),
}
