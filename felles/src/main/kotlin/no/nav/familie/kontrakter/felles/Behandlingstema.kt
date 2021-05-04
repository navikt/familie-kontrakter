package no.nav.familie.kontrakter.felles

enum class Behandlingstema(val value: String) {
    Barnetrygd("ab0270"),
    BarnetrygdEØS("ab0058"),
    OrdinærBarnetrygd("ab0180"),
    UtvidetBarnetrygd("ab0096"),
    Skolepenger("ab0177"),
    Barnetilsyn("ab0028"),
    Overgangsstønad("ab0071"),
    Kontantstøtte("ab0084"),
    Feilutbetaling("ab0006"),
    Tilbakebetaling("ab0007") // Tilbakekreving
}