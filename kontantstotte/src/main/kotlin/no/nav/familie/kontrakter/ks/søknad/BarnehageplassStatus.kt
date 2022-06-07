package no.nav.familie.kontrakter.ks.søknad

enum class BarnehageplassStatus(val beskrivelse: String) {
    garIkkeIBarnehage("Går ikke i barnehage"),
    harBarnehageplass("Har barnehageplass"),
    harSluttetIBarnehage("Har sluttet i barnehage"),
    skalBegynneIBarnehage("Skal begynne i barnehage"),
    skalSlutteIBarnehage("Skal slutte i barnehage");
}
