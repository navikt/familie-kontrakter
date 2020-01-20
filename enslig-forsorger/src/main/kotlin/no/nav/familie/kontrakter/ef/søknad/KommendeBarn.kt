@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class KommendeBarn(val navn: Felt<String>,
                        val fnr: Felt<String>?,
                        val annenForelder: Felt<Forelder>?,
                        val samvær: Felt<Samvær>?,
                        val erBarnetFødt: Felt<Boolean>,
                        val fødselTermindato: Felt<LocalDate>,
                        val skalBarnetBoHosSøker: Felt<Boolean>,
                        val terminbekreftelse: Felt<Dokument>?)
