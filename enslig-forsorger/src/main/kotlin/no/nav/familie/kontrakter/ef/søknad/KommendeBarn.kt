@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class KommendeBarn(val navn: Søknadsfelt<String>,
                        val fnr: Søknadsfelt<String>? = null,
                        val annenForelder: Søknadsfelt<Forelder>? = null,
                        val samvær: Søknadsfelt<Samvær>? = null,
                        val erBarnetFødt: Søknadsfelt<Boolean>,
                        val fødselTermindato: Søknadsfelt<LocalDate>,
                        val skalBarnetBoHosSøker: Søknadsfelt<Boolean>,
                        val terminbekreftelse: Søknadsfelt<Dokument>? = null)
