
package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class KommendeBarn(val navn: Søknadsfelt<String>,
                        val fnr: Søknadsfelt<String>? = null,
                        val erBarnetFødt: Søknadsfelt<Boolean>,
                        val fødselTermindato: Søknadsfelt<LocalDate>,
                        val terminbekreftelse: Søknadsfelt<Dokument>? = null,
                        val skalBarnetBoHosSøker: Søknadsfelt<Boolean>,
                        val annenForelder: Søknadsfelt<Forelder>? = null,
                        val samvær: Søknadsfelt<Samvær>? = null)
