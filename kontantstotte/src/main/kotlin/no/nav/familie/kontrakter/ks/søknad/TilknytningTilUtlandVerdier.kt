package no.nav.familie.kontrakter.ks.søknad

enum class TilknytningTilUtlandVerdier(val beskrivelse: String) {
    jaINorge("Ja, i Norge"),
    jaIEOS("Ja, i et EØS-land"),
    jaLeggerSammenPerioderEOS("Ja, hvis jeg legger sammen perioder i EØS-land"),
    nei("Nei"),
    Ubesvart("Ubesvart")
}