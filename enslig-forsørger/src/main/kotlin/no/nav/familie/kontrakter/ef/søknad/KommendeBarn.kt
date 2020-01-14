package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class KommendeBarn(val navn: String,
                        val fnr: String,
                        val annenForelder: ForelderDto,
                        val samvær: Samvær,
                        val erBarnetFødt: Spørsmål<Boolean>,
                        val fødselTermindato: LocalDate,
                        val skalBarnetBoHosSøker: Spørsmål<Boolean>,
                        val terminbekreftelse: Dokument)
