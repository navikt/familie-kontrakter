package no.nav.familie.kontrakter.ks.søknad

enum class TilknytningTilUtlandVerdier(val beskrivelse: String) {
    jaINorge("Ja, i Norge"), // ktlint-disable enum-entry-name-case
    jaIEOS("Ja, i et EØS-land"), // ktlint-disable enum-entry-name-case
    jaLeggerSammenPerioderEOS("Ja, hvis jeg legger sammen perioder i EØS-land"), // ktlint-disable enum-entry-name-case
    nei("Nei"), // ktlint-disable enum-entry-name-case
    Ubesvart("Ubesvart"), // ktlint-disable enum-entry-name-case
}
