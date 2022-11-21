package no.nav.familie.kontrakter.ks.infotrygd.feed

import java.time.LocalDate

open class KontantStøtteFeedDto(val type: KontantstøtteType)

data class VedtakDto(val datoStartNyKS: LocalDate, val fnrStoenadsmottaker: String): KontantStøtteFeedDto(KontantstøtteType.KS_Vedtak)

data class StartBehandlingDto(val fnrStoenadsmottaker: String): KontantStøtteFeedDto(KontantstøtteType.KS_StartBeh)


@Suppress("ktlint:enum-entry-name-case")
enum class KontantstøtteType {
    KS_Vedtak,
    KS_StartBeh
}