package no.nav.familie.kontrakter.ef.personhendelse

import no.nav.familie.kontrakter.felles.ef.StønadType

data class NyeBarnDto(val nyeBarn: List<NyttBarn>)

data class NyttBarn(val personIdent: String, val stønadstype: StønadType, val årsak: NyttBarnÅrsak)

enum class NyttBarnÅrsak {
    BARN_FINNES_IKKE_PÅ_BEHANDLING,
    FØDT_FØR_TERMIN
}
