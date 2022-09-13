package no.nav.familie.kontrakter.felles.klage

import no.nav.familie.kontrakter.felles.Tema
import no.nav.familie.kontrakter.felles.ef.StønadType

enum class Stønadstype {
    BARNETRYGD,
    OVERGANGSSTØNAD,
    BARNETILSYN,
    SKOLEPENGER,
    KONTANTSTØTTE;

    fun tilTema(): Tema {
        return when (this) {
            BARNETRYGD -> Tema.BAR
            BARNETILSYN, OVERGANGSSTØNAD, SKOLEPENGER -> Tema.ENF
            KONTANTSTØTTE -> Tema.KON
        }
    }

    companion object {
        fun fraEfStønadstype(stønadType: StønadType): Stønadstype {
            return when(stønadType) {
                StønadType.OVERGANGSSTØNAD -> OVERGANGSSTØNAD
                StønadType.BARNETILSYN -> BARNETILSYN
                StønadType.SKOLEPENGER -> SKOLEPENGER
            }
        }
    }
}