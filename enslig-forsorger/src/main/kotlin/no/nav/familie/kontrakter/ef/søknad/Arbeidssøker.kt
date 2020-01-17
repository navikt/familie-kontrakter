package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Arbeidssøker(val registrertSomArbeidssøkerNav: Spørsmål<Boolean>,
                        val villigTilÅTaImotTilbudOmArbeid: Spørsmål<Boolean>,
                        val kanDuBegynneInnenEnUke: Spørsmål<Boolean>,
                        val kanDuSkaffeBarnepassInnenEnUke: Spørsmål<Boolean>,
                        val hvorØnskerDuArbeid: Spørsmål<String>,
                        val ønskerDuMinst50ProsentStilling: Spørsmål<Boolean>,
                        val utdanningEtterGrunnskolen: Spørsmål<Boolean>,
                        val tidligereUtdanninger: List<Utdanning>? = null)