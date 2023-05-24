package no.nav.familie.kontrakter.ks.søknad

enum class BarnehageplassStatus(val beskrivelse: String) {
    garIkkeIBarnehage("Går ikke i barnehage"), // ktlint-disable enum-entry-name-case
    harBarnehageplass("Har barnehageplass"), // ktlint-disable enum-entry-name-case
    harSluttetIBarnehage("Har sluttet i barnehage"), // ktlint-disable enum-entry-name-case
    skalBegynneIBarnehage("Skal begynne i barnehage"), // ktlint-disable enum-entry-name-case
    skalSlutteIBarnehage("Skal slutte i barnehage"), // ktlint-disable enum-entry-name-case
}
