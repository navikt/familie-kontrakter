package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class UnderUtdanning(val skoleUtdanningssted: Felt<String>,
                          val utdanning: Felt<Utdanning>,
                          val offentligEllerPrivat: Felt<String>,
                          val utdanningEtterGrunnskolen: Felt<Boolean>,
                          val tidligereUtdanninger: Felt<List<Utdanning>>?)