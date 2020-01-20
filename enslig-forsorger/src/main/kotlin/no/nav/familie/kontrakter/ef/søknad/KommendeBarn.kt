@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class KommendeBarn(val navn: Felt<String>,
                        val fnr: Felt<String>? = null,
                        val annenForelder: Felt<Forelder>? = null,
                        val samvær: Felt<Samvær>? = null,
                        val erBarnetFødt: Felt<Boolean>,
                        val fødselTermindato: Felt<LocalDate>,
                        val skalBarnetBoHosSøker: Felt<Boolean>,
                        val terminbekreftelse: Felt<Dokument>? = null)
