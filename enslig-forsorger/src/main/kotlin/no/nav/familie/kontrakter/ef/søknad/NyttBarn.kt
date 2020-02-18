package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class NyttBarn(val navn: Søknadsfelt<String>? = null,
                    val fødselsnummer: Søknadsfelt<String>? = null,
                    val erBarnetFødt: Søknadsfelt<Boolean>,
                    val fødselTermindato: Søknadsfelt<LocalDate>,
                    val terminbekreftelse: Søknadsfelt<Dokument>? = null,
                    val skalBarnetBoHosSøker: Søknadsfelt<Boolean>,
                    val annenForelder: Søknadsfelt<AnnenForelder>? = null,
                    val samvær: Søknadsfelt<Samvær>? = null)