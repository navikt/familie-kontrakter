package no.nav.familie.kontrakter.ba.infotrygd.feed

import java.time.LocalDate

open class BarnetrygdFeedDto(val type: BarnetrygdType)

data class FødselsDto(val fnrBarn: String) : BarnetrygdFeedDto(BarnetrygdType.BA_Foedsel_v1)

data class VedtakDto(val datoStartNyBa: LocalDate,
                     val fnrStoenadsmottaker: String) : BarnetrygdFeedDto(BarnetrygdType.BA_Vedtak_v1)

data class StartBehandlingDto(val fnrStoenadsmottaker: String) : BarnetrygdFeedDto(BarnetrygdType.BA_StartBeh)


@Suppress("ktlint:enum-entry-name-case")
enum class BarnetrygdType {

    BA_Vedtak_v1,
    BA_Foedsel_v1,
    BA_StartBeh
}