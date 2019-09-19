package no.nav.familie.ks.søknadkontrakt

enum class TilknytningTilUtlandVerdier private constructor(val beskrivelse: String){
    jaINorge("Ja, i Norge"),
    jaIEOS("Ja, i et EØS-land"),
    jaLeggerSammenPerioderEOS("Ja, hvis jeg legger sammen perioder i EØS-land"),
    nei("Nei"),
    Ubesvart("Ubesvart")
}