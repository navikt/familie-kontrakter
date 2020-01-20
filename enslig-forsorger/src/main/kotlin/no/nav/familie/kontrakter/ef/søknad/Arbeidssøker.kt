package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Arbeidssøker(val registrertSomArbeidssøkerNav: Felt<Boolean>,
                        val villigTilÅTaImotTilbudOmArbeid: Felt<Boolean>,
                        val kanDuBegynneInnenEnUke: Felt<Boolean>,
                        val kanDuSkaffeBarnepassInnenEnUke: Felt<Boolean>,
                        val hvorØnskerDuArbeid: Felt<String>,
                        val ønskerDuMinst50ProsentStilling: Felt<Boolean>,
                        val utdanningEtterGrunnskolen: Felt<Boolean>,
                        val tidligereUtdanninger: Felt<List<Utdanning>>? = null)