package no.nav.familie.kontrakter.felles.tilbakekreving

enum class Ytelsestype(val kode: String, val navn: Map<Språkkode, String>) {
    BARNETRYGD("BA", mapOf(Språkkode.NB to "Barnetrygd",
                           Språkkode.NN to "Barnetrygd")),
    OVERGANGSSTØNAD("OG", mapOf(Språkkode.NB to "Overgangsstønad",
                                Språkkode.NN to "Overgangsstønad")),
    BARNETILSYN("BT", mapOf(Språkkode.NB to "Stønad til barnetilsyn",
                            Språkkode.NN to "Stønad til barnetilsyn")),
    SKOLEPENGER("SP", mapOf(Språkkode.NB to "Stønad til skolepenger",
                            Språkkode.NN to "Stønad til skulepengar")),
    KONTANTSTØTTE("KS", mapOf(Språkkode.NB to "Kontantstøtte",
                              Språkkode.NN to "Kontantstøtte"));
}
