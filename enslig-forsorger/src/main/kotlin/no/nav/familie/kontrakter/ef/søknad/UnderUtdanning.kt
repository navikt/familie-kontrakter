package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class UnderUtdanning(val skoleUtdanningssted: String,
                          val utdanning: Utdanning,
                          val offentligEllerPrivat: Spørsmål<String>,
                          val utdanningEtterGrunnskolen: Spørsmål<Boolean>,
                          val tidligereUtdanninger: List<Utdanning>? = null)