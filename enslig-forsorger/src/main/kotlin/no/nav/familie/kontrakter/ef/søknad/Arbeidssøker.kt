package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Arbeidssøker(val registrertSomArbeidssøkerNav: Søknadsfelt<Boolean>,
                        val villigTilÅTaImotTilbudOmArbeid: Søknadsfelt<Boolean>,
                        val kanDuBegynneInnenEnUke: Søknadsfelt<Boolean>,
                        val kanDuSkaffeBarnepassInnenEnUke: Søknadsfelt<Boolean>,
                        val hvorØnskerDuArbeid: Søknadsfelt<String>,
                        val ønskerDuMinst50ProsentStilling: Søknadsfelt<Boolean>,
                        val utdanningEtterGrunnskolen: Søknadsfelt<Boolean>,
                        val tidligereUtdanninger: Søknadsfelt<List<Utdanning>>? = null)
