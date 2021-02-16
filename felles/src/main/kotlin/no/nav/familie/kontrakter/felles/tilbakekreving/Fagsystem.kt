package no.nav.familie.kontrakter.felles.tilbakekreving

enum class Fagsystem(val navn: String, val tema: String) {
    BA("BARNETRYGD", "BAR"),
    EF("ENSLIG FORELDER", "ENF"),
    KS("KONTANTSTØTTE", "KON");

    companion object {

        fun fraYtelsestype(type: Ytelsestype): Fagsystem {
            return when (type) {
                Ytelsestype.BARNETRYGD -> BA
                Ytelsestype.KONTANTSTØTTE -> KS
                Ytelsestype.OVERGANGSSTØNAD -> EF
                Ytelsestype.BARNETILSYN -> EF
                Ytelsestype.SKOLEPENGER -> EF
            }
        }
    }
}
