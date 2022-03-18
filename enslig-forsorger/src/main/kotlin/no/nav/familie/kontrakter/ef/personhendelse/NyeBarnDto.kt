package no.nav.familie.kontrakter.ef.personhendelse

data class NyeBarnDto(val nyeBarn: List<NyttBarn>)

data class NyttBarn(val personIdent: String, val årsak: NyttBarnÅrsak)

enum class NyttBarnÅrsak {
    BARN_FINNES_IKKE_PÅ_BEHANDLING,
    FØDT_FØR_TERMIN
}
