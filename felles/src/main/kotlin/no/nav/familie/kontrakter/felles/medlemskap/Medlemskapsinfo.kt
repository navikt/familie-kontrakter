package no.nav.familie.kontrakter.felles.medlemskap

data class Medlemskapsinfo(
    val personIdent: String,
    val gyldigePerioder: List<PeriodeInfo>,
    val avvistePerioder: List<PeriodeInfo>,
    val uavklartePerioder: List<PeriodeInfo>,
)
