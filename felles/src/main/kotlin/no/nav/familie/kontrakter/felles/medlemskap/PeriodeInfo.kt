package no.nav.familie.kontrakter.felles.medlemskap

import java.time.LocalDate

data class PeriodeInfo(
    val periodeStatus: PeriodeStatus,
    val periodeStatusÅrsak: PeriodeStatusÅrsak? = null,
    val fom: LocalDate,
    val tom: LocalDate,
    val gjelderMedlemskapIFolketrygden: Boolean,
    val grunnlag: String,
    val dekning: String? = null,
)
