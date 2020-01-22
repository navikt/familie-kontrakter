package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class UnderUtdanning(val skoleUtdanningssted: Søknadsfelt<String>,
                          val utdanning: Søknadsfelt<Utdanning>,
                          val offentligEllerPrivat: Søknadsfelt<String>,
                          val utdanningEtterGrunnskolen: Søknadsfelt<Boolean>,
                          val tidligereUtdanninger: Søknadsfelt<List<Utdanning>>? = null)
