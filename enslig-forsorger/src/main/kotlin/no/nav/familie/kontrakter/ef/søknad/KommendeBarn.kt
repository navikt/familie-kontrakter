@file:ContextualSerialization(LocalDate::class)

package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class KommendeBarn(val navn: String,
                        val fnr: String?,
                        val annenForelder: Forelder?,
                        val samvær: Samvær?,
                        val erBarnetFødt: Spørsmål<Boolean>,
                        val fødselTermindato: LocalDate,
                        val skalBarnetBoHosSøker: Spørsmål<Boolean>,
                        val terminbekreftelse: Dokument?)
