package no.nav.familie.kontrakter.felles.klage

import no.nav.familie.kontrakter.felles.Fagsystem

enum class Fagsystem {
    EF,
    BA,
    KS,
    ;

    fun tilFagsaksystem(): Fagsystem =
        when (this) {
            EF -> Fagsystem.EF
            BA -> Fagsystem.BA
            KS -> Fagsystem.KONT
        }
}
