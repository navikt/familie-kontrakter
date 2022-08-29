package no.nav.familie.kontrakter.ba.tss

data class SøkSamhandlerInfoRequest(
    val navn: String?,
    val side: Int = 0,
    val postNr: String? = null,
    val område: String? = null
)

data class SøkSamhandlerInfo(
    val finnesMerInfo: Boolean,
    val samhandlere: List<SamhandlerInfo>
)

data class SamhandlerInfo(
    val tssEksternId: String,
    val navn: String,
    val adresser: List<SamhandlerAdresse> = emptyList(),
    val orgNummer: String? = null
)

data class SamhandlerAdresse(
    val adresselinjer: List<String>,
    val postNr: String,
    val postSted: String,
    val adresseType: String
)
